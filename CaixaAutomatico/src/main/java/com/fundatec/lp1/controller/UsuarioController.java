package com.fundatec.lp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fundatec.lp1.models.Usuario;
import com.fundatec.lp1.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvarUsuarioESaldo(@RequestBody Usuario usuario,
			UriComponentsBuilder ucBuilder) {
		usuarioService.save(usuario);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/usuarios/{id}")
				.buildAndExpand(usuario.getId()).toUri());

		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
}
