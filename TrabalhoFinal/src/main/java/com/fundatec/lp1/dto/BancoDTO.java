package com.fundatec.lp1.dto;

import com.fundatec.lp1.models.Banco;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class BancoDTO {

	private Integer id;
	private String nome;
	private Integer senha;
	
	public BancoDTO() {
		
	}
	
	public BancoDTO(Banco banco) {
		id = banco.getId();
		nome = banco.getNome();
		senha = banco.getSenha();
	}
	
	
}
