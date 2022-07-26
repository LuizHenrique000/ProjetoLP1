package com.fundatec.lp1.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@OneToOne(cascade=CascadeType.ALL)
	private Cliente cliente;

	@Column(nullable = true, name = "SENHA")
	private Integer senha;

	@Column(nullable = true, name = "SALDO")
	private Double saldo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="conta")
	private List<Movimentacao> movimentacoes;

	public Conta() {

	}

	public Conta(Integer id, StatusConta status, Cliente cliente, Integer senha, Double saldo,
			List<Movimentacao> movimentacoes) {
		this.id = id;
		this.status = status;
		this.cliente = cliente;
		this.senha = senha;
		this.saldo = saldo;
		this.movimentacoes = movimentacoes;
	}

}
