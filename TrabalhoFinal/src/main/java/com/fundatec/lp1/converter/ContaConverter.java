package com.fundatec.lp1.converter;

import com.fundatec.lp1.dto.ContaDTO;
import com.fundatec.lp1.models.Conta;

public class ContaConverter {

	public static ContaDTO converterParaDTO(Conta conta) {
		ContaDTO dto = new ContaDTO();
		dto.setId(conta.getId());
		dto.setStatus(conta.getStatus());
		dto.setCpfTitular(conta.getCpfTitular());
		dto.setSenha(conta.getSenha());
		dto.setSaldo(conta.getSaldo());
		dto.setMovimentacoes(conta.getMovimentacoes());
		return dto;
	}
	
	public static Conta converterParaEntity(ContaDTO dto) {
		Conta entity = new Conta();
		entity.setId(dto.getId());
		entity.setStatus(dto.getStatus());
		entity.setCpfTitular(dto.getCpfTitular());
		entity.setSenha(dto.getSenha());
		entity.setSaldo(dto.getSaldo());
		entity.setMovimentacoes(dto.getMovimentacoes());
		return entity;
	}
}
