package com.fundatec.lp1.requestDTO;

import com.fundatec.lp1.models.Banco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class RequestBanco {

	private Integer id;
	private String nome;
	private Integer senha;
	
	public RequestBanco() {
		
	}
	
	public RequestBanco(Banco banco) {
		id = banco.getId();
		nome = banco.getNome();
		senha = banco.getSenha();
	}
	
	
}
