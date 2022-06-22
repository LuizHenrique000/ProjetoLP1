package com.fundatec.lp1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "BANCO")
public class Banco {

	@Column(nullable=true, name="ID")
	private Integer id;
	
	@Column(nullable=true, name="NOME")
	private String nome;
	
	@Column(nullable=true, name="SENHA")
	private Integer senha;

	
}
//Metodo para cadastrar clientes
//Metodo carteira de clientes