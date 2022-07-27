package com.fundatec.lp1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundatec.lp1.converter.ContaConverter;
import com.fundatec.lp1.enums.StatusConta;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.repository.ContaRepository;
import com.fundatec.lp1.requestDTO.RequestConta;
import com.fundatec.lp1.service.exceptions.EntityNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public RequestConta findById(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		ContaConverter.converterParaRequestDTO(entity);
		RequestConta dto = new RequestConta(entity);
		return dto;
	}

	public RequestConta adicionarConta(RequestConta dto) {
		Conta entidade = ContaConverter.converterParaEntity(dto);
		Conta entidadePersistida = repository.save(entidade);
		return ContaConverter.converterParaRequestDTO(entidadePersistida);

	}

	public List<Conta> findAll() {
		List<Conta> contas = repository.findAll();
		return contas;
	}
		
	public RequestConta ativarContaPorId(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));;
		RequestConta dto = new RequestConta(entity);
		entity.setStatus(StatusConta.ATIVA);
		repository.save(entity);
		return dto;

	}
	
	public RequestConta desativarContaPorId(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		RequestConta dto = new RequestConta(entity);
		entity.setStatus(StatusConta.INATIVA);
		repository.save(entity);
		return dto;

	}
}
