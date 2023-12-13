package com.generation.ajudaquemfaz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_categorias")
public class Categoria {

	@Size(max =255, message = "O tipo serviço deve conter entre 5 e 255 caracteres.")
	@NotBlank
	public String tipoServico;

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	
}
