package com.fundatec.lp1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME",nullable = true)
	private String nome;
	
	@Column(name = "SALDO",nullable = true)
	private Double saldo;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, Double saldo) {
		setNome(nome);
		setSaldo(saldo);
	}
	
}
