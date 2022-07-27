package com.fundatec.lp1.converter;

import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.requestDTO.RequestConta;
import com.fundatec.lp1.responseDTO.ResponseConta;

public class ContaConverter {

	public static RequestConta converterParaRequestDTO(Conta conta) {
		RequestConta dto = new RequestConta();
		dto.setId(conta.getId());
		dto.setStatus(conta.getStatus());
		dto.setCliente(conta.getCliente());
		dto.setSenha(conta.getSenha());
		dto.setSaldo(conta.getSaldo());
		dto.setMovimentacoes(conta.getMovimentacoes());
		return dto;
	}
	
	public static Conta converterParaEntity(RequestConta dto) {
		Conta entity = new Conta();
		entity.setId(dto.getId());
		entity.setStatus(dto.getStatus());
		entity.setCliente(dto.getCliente());
		entity.setSenha(dto.getSenha());
		entity.setSaldo(dto.getSaldo());
		entity.setMovimentacoes(dto.getMovimentacoes());
		return entity;
	}
	
	public static ResponseConta converterParaResponseDTO(Conta conta) {
		ResponseConta dto = new ResponseConta();
		dto.setStatus(conta.getStatus());
		dto.setCliente(conta.getCliente());
		dto.setSaldo(conta.getSaldo());
		return dto;
	}
}
