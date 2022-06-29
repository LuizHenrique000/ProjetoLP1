package com.fundatec.lp1.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ClienteDTO {

	private Integer id;
	private String nome;
	private String cpf;
	private String endereco;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Integer id, String nome,String cpf, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	
	
	
}
