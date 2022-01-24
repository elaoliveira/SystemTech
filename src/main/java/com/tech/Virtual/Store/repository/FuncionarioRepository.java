package com.tech.Virtual.Store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tech.Virtual.Store.model.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	public Optional<Funcionario> findByEmail(String funcionario);
}
