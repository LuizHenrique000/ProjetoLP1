
package com.fundatec.lp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundatec.lp1.requestDTO.RequestBanco;
import com.fundatec.lp1.service.BancoService;

@RestController

@RequestMapping(value = "/banco")
public class BancoController {

	@Autowired
	private BancoService service;

	@PostMapping
	public ResponseEntity<RequestBanco> registrarBanco(@RequestBody RequestBanco dto) {
		RequestBanco bancoDTO = service.adicionarBanco(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bancoDTO);

	}

}
