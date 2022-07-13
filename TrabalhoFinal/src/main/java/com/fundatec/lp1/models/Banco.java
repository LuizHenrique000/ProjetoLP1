package com.fundatec.lp1.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "BANCO")
public class Banco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true, name = "NOME")
	private String nome;

	@Column(nullable = true, name = "SENHA")
	private Integer senha;
	
	@ElementCollection
	private List<Cliente> clientesCadastrados;

	public Banco() {

	}

	public Banco(Integer id, String nome, Integer senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}

}
