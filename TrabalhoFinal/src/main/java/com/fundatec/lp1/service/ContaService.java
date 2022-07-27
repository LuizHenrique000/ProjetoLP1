package com.fundatec.lp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundatec.lp1.converter.ContaConverter;
import com.fundatec.lp1.enums.StatusConta;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.repository.ContaRepository;
import com.fundatec.lp1.requestDTO.RequestConta;
import com.fundatec.lp1.responseDTO.ResponseConta;
import com.fundatec.lp1.service.exceptions.EntityNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public ResponseConta findById(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		return ContaConverter.converterParaResponseDTO(entity);
		
	}

	public ResponseConta adicionarConta(RequestConta dto) {
		Conta entidade = ContaConverter.converterParaEntity(dto);
		Conta entidadePersistida = repository.save(entidade);
		return ContaConverter.converterParaResponseDTO(entidadePersistida);

	}

	public List<Conta> findAll() {
		List<Conta> contas = repository.findAll();
		return contas;
	}
		
	public ResponseConta ativarContaPorId(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));;
		entity.setStatus(StatusConta.ATIVA);
		repository.save(entity);
		return ContaConverter.converterParaResponseDTO(entity);

	}
	
	public ResponseConta desativarContaPorId(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		entity.setStatus(StatusConta.INATIVA);
		repository.save(entity);
		return ContaConverter.converterParaResponseDTO(entity);

	}
}
