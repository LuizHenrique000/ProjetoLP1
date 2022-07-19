package com.fundatec.lp1.dto;

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
public class ContaDTO {

	private Integer id;
	private StatusConta status = StatusConta.INDEFINIDA;
	private String cpfTitular;
	private Integer senha;
	private Double saldo;
	private List<Movimentacao> movimentacoes;

	public ContaDTO() {

	}

	public ContaDTO(Conta conta) {
		id = conta.getId();
		status = conta.getStatus();
		cpfTitular = conta.getCpfTitular();
		senha = conta.getSenha();
		saldo = conta.getSaldo();
		movimentacoes = conta.getMovimentacoes();
	}

}
