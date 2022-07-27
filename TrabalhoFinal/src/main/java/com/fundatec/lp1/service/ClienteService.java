package com.fundatec.lp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundatec.lp1.converter.ClienteConverter;
import com.fundatec.lp1.enums.TipoCliente;
import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.repository.ClienteRepository;
import com.fundatec.lp1.requestDTO.RequestCliente;
import com.fundatec.lp1.responseDTO.ResponseCliente;
import com.fundatec.lp1.service.exceptions.ClienteException;
import com.fundatec.lp1.service.exceptions.EntityNotFoundException;
import com.fundatec.lp1.service.exceptions.IsTitularException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public ResponseCliente adicionarCliente(RequestCliente dto) {
		Cliente entidade = ClienteConverter.converterParaEntity(dto);
		Cliente entidadePersistida = repository.save(entidade);
		return ClienteConverter.converterParaResponse(entidadePersistida);
	}

	public void deletarClientePorId(Integer id) {
		Cliente cliente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente inexistente"));
		if (cliente.getTipoCliente() == null) {
			throw new ClienteException("TipoCliente precisa ser TITULAR ou NAO_TITULAR");
		}

		if (cliente.getTipoCliente().equals(TipoCliente.TITULAR)) {
			throw new IsTitularException("Cliente titular");
		}

		repository.deleteById(id);

	}
}
