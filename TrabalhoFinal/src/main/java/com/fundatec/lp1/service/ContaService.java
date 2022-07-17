package com.fundatec.lp1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundatec.lp1.converter.ContaConverter;
import com.fundatec.lp1.dto.ContaDTO;
import com.fundatec.lp1.enums.StatusConta;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.repository.ContaRepository;
import com.fundatec.lp1.service.exceptions.EntityNotFoundException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public ContaDTO findById(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		ContaConverter.converterParaDTO(entity);
		ContaDTO dto = new ContaDTO(entity);
		return dto;
	}

	public ContaDTO adicionarConta(ContaDTO dto) {
		Conta entidade = ContaConverter.converterParaEntity(dto);
		Conta entidadePersistida = repository.save(entidade);
		return ContaConverter.converterParaDTO(entidadePersistida);

	}

	public List<Conta> findAll() {
		List<Conta> contas = repository.findAll();
		return contas;
	}
		
	public ContaDTO ativarContaPorId(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));;
		ContaDTO dto = new ContaDTO(entity);
		dto.setStatus(StatusConta.ATIVA);
		return dto;

	}
	
	public ContaDTO desativarContaPorId(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		ContaDTO dto = new ContaDTO(entity);
		dto.setStatus(StatusConta.INATIVA);
		return dto;

	}
}
