package com.fundatec.lp1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundatec.lp1.converter.ContaConverter;
import com.fundatec.lp1.dto.ContaDTO;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public ContaDTO findById(Integer id) {
		Conta entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Conta inexistente"));
		ContaConverter.converterParaDTO(entity);
		ContaDTO dto = new ContaDTO(entity);
		return dto;
	}

	public List<Conta> findAll() {
		List<Conta> contas = repository.findAll();
		return contas;
	}
}
