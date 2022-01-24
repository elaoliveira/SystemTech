package com.tech.Virtual.Store.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tech.Virtual.Store.model.Funcionario;
import com.tech.Virtual.Store.model.FuncionarioDTO;
import com.tech.Virtual.Store.repository.FuncionarioRepository;
import org.apache.commons.codec.binary.Base64;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repositorio;
	
	public Optional<FuncionarioDTO> Logar(Optional<FuncionarioDTO> costumer) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Funcionario> funcionario = repositorio.findByEmail(costumer.get().getEmail());
       

        if(funcionario.isPresent()) {
            if(encoder.matches(costumer.get().getSenha(), funcionario.get().getSenha())) {
                String auth = costumer.get().getEmail() + ":" + costumer.get().getSenha();
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                costumer.get().setToken(authHeader);
                return costumer;
                
              
            }
        }
       return null;
	}
}
