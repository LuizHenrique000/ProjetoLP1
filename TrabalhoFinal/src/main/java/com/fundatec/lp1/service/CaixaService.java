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

	public Double consultarSaldo(Integer senha, Integer id) {
		Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		validar(senha, conta);
		Double saldo = conta.getSaldo();
		return saldo;

	}

	public Conta depositar(Integer senha, Integer id, Double deposito) {
		Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		validar(senha, conta);
		Double saldo = conta.getSaldo() + deposito;
		conta.setSaldo(saldo);
		return repository.save(conta);
	}
	
	public Double sacar(Integer senha, Integer id, Double saque) {
		Conta conta = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta inexistente"));
		validar(senha, conta);
		Double saldo = conta.getSaldo() - saque;
		conta.setSaldo(saldo);
		repository.save(conta);
		return saque;
	}

	public void validar(Integer senha, Conta conta) {
		Integer senhaConta = conta.getSenha();
		if (senhaConta.intValue() != senha.intValue()) {
			throw new SenhaInvalidaException("Senha invalida");
		}
	}

}
