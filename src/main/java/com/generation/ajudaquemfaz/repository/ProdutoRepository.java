package com.generation.ajudaquemfaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.ajudaquemfaz.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	// Achar por Nome
	List<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	
}
