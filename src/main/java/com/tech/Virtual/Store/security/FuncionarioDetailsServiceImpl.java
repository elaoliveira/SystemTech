package com.tech.Virtual.Store.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tech.Virtual.Store.model.Funcionario;
import com.tech.Virtual.Store.repository.FuncionarioRepository;

@Service
public class FuncionarioDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private FuncionarioRepository repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Funcionario> costumer = repositorio.findByEmail(userName);
        costumer.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

        return costumer.map(FuncionarioDetailsImpl::new).get();
	}

	
}
