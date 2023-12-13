package com.generation.ajudaquemfaz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_categorias")
public class Categoria {
	
	@NotBlank(message = "O Atributo Setor é obrigatório")
	@Size(max = 255, message = "O Atributo Setor deve conter no máximo 255 caractéres")
	private String setor;

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	

}
