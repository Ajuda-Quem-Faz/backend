package com.generation.ajudaquemfaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.ajudaquemfaz.model.Categoria;
import com.generation.ajudaquemfaz.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@GetMapping("/setor/{setor}")
	public ResponseEntity<List<Categoria>> getAllBySetor(@PathVariable String setor){
		return ResponseEntity.ok(categoriaRepository.findAllBySetorContainingIgnoreCase(setor));
	}
	
	@GetMapping("/servico/{servico}")
	public ResponseEntity<List<Categoria>> getAllByServico(@PathVariable String servico){
		return ResponseEntity.ok(categoriaRepository.findAllByTipoServicoContainingIgnoreCase(servico));
	}
	
	//Método para Criação da categoria
	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	//Método para Atualização da categoria
	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria){
		if(categoriaRepository.existsById(categoria.getId()))
			return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não existe.", null);
	}
	
}
