package com.fundatec.lp1.requestDTO;

import java.util.List;

import com.fundatec.lp1.models.Banco;
import com.fundatec.lp1.models.Cliente;

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
	private List<Cliente> clientesCadastros;
	
	public RequestBanco() {
		
	}
	
	public RequestBanco(Banco banco) {
		id = banco.getId();
		nome = banco.getNome();
		senha = banco.getSenha();
		clientesCadastros = banco.getClientesCadastrados();
	}
	
	
}
