package com.fundatec.lp1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fundatec.lp1.models.Conta;
import com.fundatec.lp1.requestDTO.RequestConta;
import com.fundatec.lp1.responseDTO.ResponseConta;
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

	@PostMapping
	public ResponseEntity<ResponseConta> adicionarConta(@RequestBody RequestConta dto) {
		ResponseConta contaDTO = service.adicionarConta(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(contaDTO);

	}

}
