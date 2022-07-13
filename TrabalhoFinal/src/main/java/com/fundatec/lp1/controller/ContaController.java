package com.fundatec.lp1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fundatec.lp1.dto.ContaDTO;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.service.ContaService;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

	@Autowired
	private ContaService service;

	@GetMapping
	public ResponseEntity<List<Conta>> findAll() {
		List<Conta> contas = service.findAll();
		return ResponseEntity.ok(contas);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<ContaDTO> ativarContaPorId(@PathVariable Integer id){
		ContaDTO contaDTO = service.ativarContaPorId(id);
		return ResponseEntity.ok(contaDTO);
	}
	
}

