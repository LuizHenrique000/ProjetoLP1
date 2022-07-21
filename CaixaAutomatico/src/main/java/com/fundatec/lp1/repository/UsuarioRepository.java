package com.fundatec.lp1.repository;

import java.util.Collection;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fundatec.lp1.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Id, Long> {

	
Usuario findByNome(String nome);
	
	@Query("select u from Usuario u where UPPER(u.nome) like UPPER(?)")
    Collection<Usuario> search(String term);
	
}
