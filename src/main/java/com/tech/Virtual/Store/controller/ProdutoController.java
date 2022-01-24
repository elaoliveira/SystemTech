package com.tech.Virtual.Store.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.tech.Virtual.Store.model.Produto;
import com.tech.Virtual.Store.repository.ProdutoRepository;

@Controller
public class ProdutoController {

//	private static String caminhoImagens = "/home/frank/Documents/imagens/";

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/workspace/produtos/cadastrar")
	public ModelAndView cadastrar(Produto produto) {
		ModelAndView mv = new ModelAndView("workspace/produtos/cadastro");
		mv.addObject("produto", produto);
		return mv;
	}

	@GetMapping("/workspace/produtos/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("workspace/produtos/lista");
		mv.addObject("listaProdutos", produtoRepository.findAll());
		return mv;
	}

	@GetMapping("/workspace/produtos/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return cadastrar(produto.get());
	}

	@GetMapping("/workspace/produtos/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		produtoRepository.delete(produto.get());
		return listar();
	}

	@PostMapping("/workspace/produtos/salvar")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(produto);
		}
		produtoRepository.saveAndFlush(produto);
		return cadastrar(new Produto());
	}
}