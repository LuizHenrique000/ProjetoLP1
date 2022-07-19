package com.fundatec.lp1.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fundatec.lp1.enums.StatusConta;

import lombok.Data;

@Data
@Entity(name = "CONTA")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true, name = "STATUS_CONTA")
	@Enumerated(EnumType.STRING)
	private StatusConta status = StatusConta.INDEFINIDA;

	@Column(nullable = true, name = "CPF_TITULAR")
	private String cpfTitular;

	@Column(nullable = true, name = "SENHA")
	private Integer senha;

	@Column(nullable = true, name = "SALDO")
	private Double saldo;

	@ElementCollection
	private List<Movimentacao> movimentacoes;

	public Conta() {

	}

	public Conta(Integer id, StatusConta status, String cpfTitular, Integer senha, Double saldo,
			List<Movimentacao> movimentacoes) {
		this.id = id;
		this.status = status;
		this.cpfTitular = cpfTitular;
		this.senha = senha;
		this.saldo = saldo;
		this.movimentacoes = movimentacoes;
	}
}
