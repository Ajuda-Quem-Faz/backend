package com.generation.ajudaquemfaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.ajudaquemfaz.model.Categoria;

interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	// Achar por tipo de serviço
	List<Categoria> findAllByTipoServicoContainingIgnoreCase(@Param("servico") String servico);

	// Achar por Setor
	List<Categoria> findAllBySetorContainingIgnoreCase(@Param("setor") String setor);

}
