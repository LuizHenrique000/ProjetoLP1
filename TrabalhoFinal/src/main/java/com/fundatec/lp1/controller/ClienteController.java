package com.fundatec.lp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fundatec.lp1.dto.ClienteDTO;
import com.fundatec.lp1.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
		ClienteDTO clienteDTO = service.findById(id);
		return ResponseEntity.ok(clienteDTO);

	}

	@PostMapping
	public ResponseEntity<ClienteDTO> adicionarCliente(@RequestBody ClienteDTO dto) {
		ClienteDTO clienteDTO = service.adicionarCliente(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);

	}

}
