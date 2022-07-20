package com.fundatec.lp1.responseDTO;

import com.fundatec.lp1.models.Cliente;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ResponseCliente {

	private String nome;
	private String endereco;

	public ResponseCliente() {

	}

	public ResponseCliente(Cliente cliente) {
		nome = cliente.getNome();
		endereco = cliente.getEndereco();
	}

}
