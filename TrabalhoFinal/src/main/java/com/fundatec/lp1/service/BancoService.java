
package com.fundatec.lp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundatec.lp1.converter.BancoConverter;
import com.fundatec.lp1.dto.BancoDTO;
import com.fundatec.lp1.models.Banco;
import com.fundatec.lp1.repository.BancoRepository;

@Service
public class BancoService {

	@Autowired
	private BancoRepository repository;

	public BancoDTO adicionarBanco(BancoDTO dto) {
		Banco entidade = BancoConverter.converterParaEntity(dto);
		Banco entidadePersistida = repository.save(entidade);
		return BancoConverter.converterParaDTO(entidadePersistida);
	}
}

// Metodo carteira de clientes }
