package com.fundatec.lp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.repository.ContaRepository;
import com.fundatec.lp1.service.exceptions.EntityNotFoundException;
import com.fundatec.lp1.service.exceptions.SenhaInvalidaException;

@Service
public class CaixaService {
	
	@Autowired
	private ContaRepository repository;
	
	public Double consultarSaldo(Integer senha,Integer id) {
		Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		Integer senhaConta = conta.getSenha();
		Double saldo = conta.getSaldo();
		if (senhaConta == senha) {
			return saldo;
		} else {
			throw new SenhaInvalidaException("Senha inválida");
		}
		
	}
	
}
