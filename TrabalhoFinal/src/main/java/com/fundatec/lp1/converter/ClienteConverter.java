package com.fundatec.lp1.converter;

import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.requestDTO.RequestCliente;

public class ClienteConverter {
	
	public static RequestCliente converterParaDTO(Cliente cliente) {
		RequestCliente dto = new RequestCliente();
		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		dto.setEndereco(cliente.getEndereco());
		return dto;
	}
	
	public static Cliente converterParaEntity(RequestCliente dto) {
		Cliente entity = new Cliente();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setEndereco(dto.getEndereco());
		return entity;
	}
	
}
