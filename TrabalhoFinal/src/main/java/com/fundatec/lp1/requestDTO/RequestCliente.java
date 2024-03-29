package com.fundatec.lp1.requestDTO;

import com.fundatec.lp1.enums.TipoCliente;
import com.fundatec.lp1.models.Banco;
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
	private TipoCliente tipoCliente;
	private Banco banco;

	public RequestCliente() {

	}

	public RequestCliente(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		endereco = cliente.getEndereco();
		tipoCliente = cliente.getTipoCliente();
		banco = cliente.getBanco();
	}

}
