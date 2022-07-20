
package com.fundatec.lp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundatec.lp1.converter.BancoConverter;
import com.fundatec.lp1.models.Banco;
import com.fundatec.lp1.repository.BancoRepository;
import com.fundatec.lp1.requestDTO.RequestBanco;

@Service
public class BancoService {

	@Autowired
	private BancoRepository repository;

	public RequestBanco adicionarBanco(RequestBanco dto) {
		Banco entidade = BancoConverter.converterParaEntity(dto);
		Banco entidadePersistida = repository.save(entidade);
		return BancoConverter.converterParaDTO(entidadePersistida);
	}
}

// Metodo carteira de clientes }
