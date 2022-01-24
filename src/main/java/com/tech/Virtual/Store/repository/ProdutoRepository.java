package com.tech.Virtual.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.Virtual.Store.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}