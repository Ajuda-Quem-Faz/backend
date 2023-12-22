package com.generation.ajudaquemfaz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.ajudaquemfaz.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	// Encontrar Usuario com nome especifico
	public Optional<Usuario> findByUsuario(String usuario);
	
}