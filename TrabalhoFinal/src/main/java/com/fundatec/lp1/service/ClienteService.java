package com.fundatec.lp1.service;

import org.springframework.stereotype.Service;
import com.fundatec.lp1.dto.ClienteDTO;
import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.repository.ClienteRepository;
import com.fundatec.lp1.converter.*;

@Service
public class ClienteService {
	
	private ClienteRepository repository;
	
	public ClienteDTO findById(Integer id) {
		Cliente entity = repository.findById(id).get();
		ClienteConverter.converterParaDTO(entity);
		return null;
	}
	
	public Cliente adicionarCliente(ClienteDTO dto) {
		ClienteConverter.converterParaEntity(dto);
		return null;
	}

}
