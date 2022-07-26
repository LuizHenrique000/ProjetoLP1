package com.fundatec.lp1.requestDTO;

import java.util.List;

import com.fundatec.lp1.enums.StatusConta;
import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.models.Movimentacao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class RequestConta {

	private Integer id;
	private StatusConta status;
	private Cliente cliente;
	private Integer senha;
	private Double saldo;
	private List<Movimentacao> movimentacoes;

	public RequestConta() {

	}

	public RequestConta(Conta conta) {
		id = conta.getId();
		status = conta.getStatus();
		cliente = conta.getCliente();
		senha = conta.getSenha();
		saldo = conta.getSaldo();
		movimentacoes = conta.getMovimentacoes();
	}

}
