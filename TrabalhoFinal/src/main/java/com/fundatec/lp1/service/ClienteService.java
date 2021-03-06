package com.fundatec.lp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundatec.lp1.enums.TipoCliente;
import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.repository.ClienteRepository;
import com.fundatec.lp1.requestDTO.RequestCliente;
import com.fundatec.lp1.service.exceptions.EntityNotFoundException;
import com.fundatec.lp1.service.exceptions.IsTitularException;
import com.fundatec.lp1.converter.*;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public RequestCliente adicionarCliente(RequestCliente dto) {
		Cliente entidade = ClienteConverter.converterParaEntity(dto);
		Cliente entidadePersistida = repository.save(entidade);
		return ClienteConverter.converterParaDTO(entidadePersistida);
	}

	public RuntimeException deletarClientePorId(Integer id) {
		Cliente cliente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente inexistente"));
		if (cliente.getTipoCliente().equals(TipoCliente.TITULAR)) {
			throw new IsTitularException("Cliente ? titular");
		}
		return null;

	}
}
