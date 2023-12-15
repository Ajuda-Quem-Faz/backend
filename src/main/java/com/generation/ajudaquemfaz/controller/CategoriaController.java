package com.generation.ajudaquemfaz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.generation.ajudaquemfaz.model.Categoria;
import com.generation.ajudaquemfaz.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	// Método para injeção de dependências
	@Autowired
	public CategoriaRepository categoriaRepository;

	// Método para buscar Categoria por setor
	@GetMapping("/setor/{setor}")
	public ResponseEntity<List<Categoria>> getAllBySetor(@PathVariable String setor) {
		return ResponseEntity.ok(categoriaRepository.findAllBySetorContainingIgnoreCase(setor));
	}

	// Método para buscar Categoria por serviço
	@GetMapping("/servico/{servico}")
	public ResponseEntity<List<Categoria>> getAllByServico(@PathVariable String servico) {
		return ResponseEntity.ok(categoriaRepository.findAllByTipoServicoContainingIgnoreCase(servico));
	}

	// Método para listar todos as Categorias
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	// Método para Criação da Categoria
	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}

	// Método para Atualização da Categoria
	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria) {
		if (categoriaRepository.existsById(categoria.getId()))
			return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não existe.", null);
	}

	// Método para buscar Categoria por Id
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id) {
		return categoriaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// Método para deletar Categoria por Id
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		categoriaRepository.deleteById(id);
	}

}
