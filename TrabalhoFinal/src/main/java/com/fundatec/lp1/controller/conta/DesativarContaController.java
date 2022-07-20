package com.fundatec.lp1.controller.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundatec.lp1.requestDTO.RequestConta;
import com.fundatec.lp1.service.ContaService;

@RestController
@RequestMapping(value = "/desativarConta")
public class DesativarContaController {

	@Autowired
	private ContaService service;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<RequestConta> desativarContaPorId(@PathVariable Integer id) {
		RequestConta contaDTO = service.desativarContaPorId(id);
		return ResponseEntity.ok(contaDTO);

	}
}
