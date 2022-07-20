package com.fundatec.lp1.requestDTO;

import com.fundatec.lp1.models.Cliente;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class RequestCliente {

	private Integer id;
	private String nome;
	private String cpf;
	private String endereco;

	public RequestCliente() {

	}

	public RequestCliente(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		endereco = cliente.getEndereco();
	}

}
