package com.tech.Virtual.Store.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tech.Virtual.Store.model.Funcionario;
import com.tech.Virtual.Store.model.FuncionarioDTO;
import com.tech.Virtual.Store.repository.FuncionarioRepository;
import com.tech.Virtual.Store.service.FuncionarioService;

@CrossOrigin(allowedHeaders = "", origins = "")
@Controller
@RestController
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping("/workspace/funcionarios/cadastrar")
	public ModelAndView cadastrar(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("workspace/funcionarios/cadastro");
		mv.addObject("funcionario", funcionario);
		return mv;
	}

	@GetMapping("/workspace/funcionarios/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("workspace/funcionarios/lista");
		mv.addObject("listaFuncionarios", funcionarioRepository.findAll());
		return mv;
	}

	@GetMapping("/workspace/funcionarios/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return cadastrar(funcionario.get());
	}

	@GetMapping("/workspace/funcionarios/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		funcionarioRepository.delete(funcionario.get());
		return listar();
	}

	@PostMapping("/workspace/funcionarios/salvar")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(funcionario);
		}
		funcionario.setSenha(new BCryptPasswordEncoder().encode(funcionario.getSenha()));
		funcionarioRepository.saveAndFlush(funcionario);
		return cadastrar(new Funcionario());
	}
	
	@PostMapping("/workspace/funcionarios/logar")
	public ModelAndView logar(@Valid Funcionario funcionario, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(funcionario);
		}
		funcionario.setSenha(new BCryptPasswordEncoder().encode(funcionario.getSenha()));
		funcionarioRepository.saveAndFlush(funcionario);
		return cadastrar(new Funcionario());
	}
	

}
