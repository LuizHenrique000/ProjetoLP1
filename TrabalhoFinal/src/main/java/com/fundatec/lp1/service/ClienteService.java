package com.fundatec.lp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundatec.lp1.dto.ClienteDTO;
import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.repository.ClienteRepository;
import com.fundatec.lp1.converter.*;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public ClienteDTO adicionarCliente(ClienteDTO dto) {
		Cliente entidade = ClienteConverter.converterParaEntity(dto);
		Cliente entidadePersistida = repository.save(entidade);
		return ClienteConverter.converterParaDTO(entidadePersistida);
	}

}
