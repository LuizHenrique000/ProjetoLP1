package com.fundatec.lp1.responseDTO;

import java.util.List;

import com.fundatec.lp1.models.Banco;
import com.fundatec.lp1.models.Cliente;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ResponseBanco {

	private String nome;
	private List<Cliente> clientesCadastros;

	public ResponseBanco() {

	}

	public ResponseBanco(Banco banco) {
		nome = banco.getNome();
		clientesCadastros = banco.getClientesCadastrados();
	}

}
