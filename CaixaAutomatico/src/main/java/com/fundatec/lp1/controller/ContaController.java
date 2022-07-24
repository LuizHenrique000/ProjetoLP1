package com.fundatec.lp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fundatec.lp1.CaixaAutomaticoTeste;
import com.fundatec.lp1.models.Conta;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	CaixaAutomaticoTeste caixaAutomaticoTeste;
	
	@GetMapping
	public Conta findAll() {
		return caixaAutomaticoTeste.getContas();
	}
		
}
