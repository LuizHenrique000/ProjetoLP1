package com.fundatec.lp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.service.CaixaService;

@RestController
@RequestMapping(value = "/caixa")
public class CaixaAutomaticoController {

	@Autowired
	private CaixaService service;

	@GetMapping(value = "/saldo/{senha}/{id}")
	public Double consultarSaldo(@PathVariable Integer senha, @PathVariable Integer id) {
		return service.consultarSaldo(senha, id);
	}

	@PutMapping(value = "deposito/{senha}/{id}/{deposito}")
	public Conta depositar(@PathVariable Integer senha, @PathVariable Integer id, @PathVariable Double deposito) {
		return service.depositar(senha, id, deposito);

	}

}
