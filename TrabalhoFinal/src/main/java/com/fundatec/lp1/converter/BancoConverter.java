package com.fundatec.lp1.converter;

import com.fundatec.lp1.dto.BancoDTO;
import com.fundatec.lp1.models.Banco;

public class BancoConverter {

	public static BancoDTO converterParaDTO(Banco banco) {
		BancoDTO dto = new BancoDTO();
		dto.setId(banco.getId());
		dto.setNome(banco.getNome());
		dto.setSenha(banco.getSenha());
		return dto;
	}
}
