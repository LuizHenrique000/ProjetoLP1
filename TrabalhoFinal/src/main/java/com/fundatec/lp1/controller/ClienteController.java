package com.fundatec.lp1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundatec.lp1.dto.ClienteDTO;
import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public ClienteDTO findById(@PathVariable Integer id) {
		return service.findById(id);
		
	}
	@PostMapping
	public Cliente adicionarCliente(@RequestBody ClienteDTO dto) {
		return service.adicionarCliente(dto);
		
	}
	
	
}
