package com.generation.ajudaquemfaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.ajudaquemfaz.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	// TODO : criar métodos específicos da Repository 'Produto'
	
}
