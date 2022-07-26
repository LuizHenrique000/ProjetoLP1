package com.fundatec.lp1.responseDTO;

import com.fundatec.lp1.models.Banco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ResponseBanco {

	private String nome;

	public ResponseBanco() {

	}

	public ResponseBanco(Banco banco) {
		nome = banco.getNome();
	}

}
