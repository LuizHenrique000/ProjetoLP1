package com.fundatec.lp1.converter;

import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.requestDTO.RequestCliente;
import com.fundatec.lp1.responseDTO.ResponseCliente;

public class ClienteConverter {
	
	public static RequestCliente converterParaDTO(Cliente cliente) {
		RequestCliente dto = new RequestCliente();
		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		dto.setCpf(cliente.getCpf());
		dto.setEndereco(cliente.getEndereco());
		dto.setBanco(cliente.getBanco());
		return dto;
	}
	
	public static Cliente converterParaEntity(RequestCliente dto) {
		Cliente entity = new Cliente();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setEndereco(dto.getEndereco());
		entity.setBanco(dto.getBanco());
		return entity;
	}
	
	public static ResponseCliente converterParaResponse(Cliente cliente) {
		ResponseCliente dto = new ResponseCliente();
		dto.setNome(cliente.getNome());
		dto.setCpf(cliente.getCpf());
		dto.setEndereco(cliente.getEndereco());
		dto.setBanco(cliente.getBanco());
		return dto;
	}
	
}
