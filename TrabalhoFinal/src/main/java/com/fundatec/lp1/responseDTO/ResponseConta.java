package com.fundatec.lp1.responseDTO;

import java.util.List;

import com.fundatec.lp1.enums.StatusConta;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.models.Movimentacao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ResponseConta {

	private StatusConta status = StatusConta.INDEFINIDA;
	private String cpfTitular;
	private Double saldo;
	private List<Movimentacao> movimentacoes;

	public ResponseConta() {

	}

	public ResponseConta(Conta conta) {
		status = conta.getStatus();
		saldo = conta.getSaldo();
		movimentacoes = conta.getMovimentacoes();
	}

}
