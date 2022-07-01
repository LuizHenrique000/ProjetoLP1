package com.fundatec.lp1.dto;

import com.fundatec.lp1.models.Cliente;

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

	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		cpf = cliente.getCpf();
		endereco = cliente.getEndereco();
	}

}
