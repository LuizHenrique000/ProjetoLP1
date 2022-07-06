package com.fundatec.lp1.dto;

import java.util.List;

import com.fundatec.lp1.models.Banco;
import com.fundatec.lp1.models.Cliente;

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
	private List<Cliente> clientesCadastros;
	
	public BancoDTO() {
		
	}
	
	public BancoDTO(Banco banco) {
		id = banco.getId();
		nome = banco.getNome();
		senha = banco.getSenha();
		clientesCadastros = banco.getClientesCadastrados();
	}
	
	
}
