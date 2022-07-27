package com.fundatec.lp1.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = true, name = "HORARIO")
	private LocalDateTime horario;
	
	@Column(nullable = true, name = "DESCRICAO")
	private String descricao;
	
	@ManyToOne
	private Conta conta;
	
}
