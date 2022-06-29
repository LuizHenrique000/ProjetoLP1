package com.fundatec.lp1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fundatec.lp1.dto.ClienteDTO;

import lombok.Data;

@Data
@Entity(name = "CLIENTE")
public class Cliente {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true, name = "NOME")
	private String nome;

	@Column(nullable = true, name = "CPF", length = 11)
	private String cpf;

	@Column(nullable = true, name = "ENDERECO")
	private String endereco;

	public Cliente() {
		
	}
	
	public Cliente(Integer id, String nome, String cpf, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

}
