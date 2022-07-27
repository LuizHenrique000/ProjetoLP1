package com.fundatec.lp1.converter;

import com.fundatec.lp1.models.Banco;
import com.fundatec.lp1.requestDTO.RequestBanco;
import com.fundatec.lp1.responseDTO.ResponseBanco;

public class BancoConverter {

	public static RequestBanco converterParaDTO(Banco banco) {
		RequestBanco dto = new RequestBanco();
		dto.setId(banco.getId());
		dto.setNome(banco.getNome());
		dto.setSenha(banco.getSenha());
		return dto;
	}

	public static Banco converterParaEntity(RequestBanco dto) {
		Banco entity = new Banco();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setSenha(dto.getSenha());
		return entity;
	}
	
	public static ResponseBanco converterParaResponse(Banco entity) {
		ResponseBanco responseDTO = new ResponseBanco();
		responseDTO.setNome(entity.getNome());
		return responseDTO;
	}
}
