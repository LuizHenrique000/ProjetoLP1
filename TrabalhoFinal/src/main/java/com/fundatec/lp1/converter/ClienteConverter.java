package com.fundatec.lp1.converter;

import com.fundatec.lp1.dto.ClienteDTO;
import com.fundatec.lp1.models.Cliente;

public class ClienteConverter {
	
	public static ClienteDTO converterParaDTO(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		dto.setCpf(cliente.getCpf());
		dto.setEndereco(cliente.getEndereco());
		return dto;
	}
	
	public static Cliente converterParaEntity(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setEndereco(dto.getEndereco());
		return entity;
	}
	
}
