package com.fundatec.lp1.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Movimentacao {
	
	private LocalDateTime horario;
	private String descricao;

}
