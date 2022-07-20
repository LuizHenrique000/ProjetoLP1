package com.fundatec.lp1.converter;

import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.requestDTO.RequestConta;

public class ContaConverter {

	public static RequestConta converterParaDTO(Conta conta) {
		RequestConta dto = new RequestConta();
		dto.setId(conta.getId());
		dto.setStatus(conta.getStatus());
		dto.setSenha(conta.getSenha());
		dto.setSaldo(conta.getSaldo());
		dto.setMovimentacoes(conta.getMovimentacoes());
		return dto;
	}
	
	public static Conta converterParaEntity(RequestConta dto) {
		Conta entity = new Conta();
		entity.setId(dto.getId());
		entity.setStatus(dto.getStatus());
		entity.setSenha(dto.getSenha());
		entity.setSaldo(dto.getSaldo());
		entity.setMovimentacoes(dto.getMovimentacoes());
		return entity;
	}
}
