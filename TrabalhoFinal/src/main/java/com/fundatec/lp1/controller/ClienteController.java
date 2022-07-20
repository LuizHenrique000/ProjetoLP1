package com.fundatec.lp1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.requestDTO.RequestCliente;
import com.fundatec.lp1.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> cliente = service.findAll();
		return ResponseEntity.ok(cliente);
	}

	@PostMapping
	public ResponseEntity<RequestCliente> adicionarCliente(@RequestBody RequestCliente dto) {
		RequestCliente clienteDTO = service.adicionarCliente(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarClientePorId(@PathVariable("id") Integer id){
		service.deletarClientePorId(id);
		return ResponseEntity.noContent().build();
	}


}
