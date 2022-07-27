package com.fundatec.lp1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fundatec.lp1.models.Movimentacao;
import com.fundatec.lp1.responseDTO.ResponseConta;
import com.fundatec.lp1.service.CaixaService;

@RestController
@RequestMapping(value = "/caixa")
public class CaixaAutomaticoController {

	@Autowired
	private CaixaService service;

	@GetMapping(value = "/saldo/{senha}/{id}")
	public String consultarSaldo(@PathVariable Integer senha, @PathVariable Integer id) {
		return service.consultarSaldo(senha, id);
	}

	@PutMapping(value = "deposito/{senha}/{id}/{deposito}")
	public ResponseEntity<ResponseConta> depositar(@PathVariable Integer senha, @PathVariable Integer id, @PathVariable Double deposito) {
		return ResponseEntity.ok(service.depositar(senha, id, deposito));
		
	}

	@PutMapping(value = "saque/{senha}/{id}/{saque}")
	public String sacar(@PathVariable Integer senha, @PathVariable Integer id, @PathVariable Double saque) {
		return service.sacar(senha, id, saque);
	}
	
	@GetMapping(value = "extrato/{senha}/{id}")
	public List<Movimentacao> consultarExtrato(@PathVariable Integer senha, @PathVariable Integer id){
		return service.consultarExtrato(senha, id);
		
	}

}
