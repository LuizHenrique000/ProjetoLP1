package com.fundatec.lp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundatec.lp1.models.Usuario;
import com.fundatec.lp1.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public String save(Usuario usuario) {
		Usuario u = repository.findByNome(usuario.getNome());
		
		
		return usuario.getNome();
	}
	
}
