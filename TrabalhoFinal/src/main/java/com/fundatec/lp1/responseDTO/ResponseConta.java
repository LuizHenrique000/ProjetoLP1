package com.fundatec.lp1.responseDTO;

import com.fundatec.lp1.enums.StatusConta;
import com.fundatec.lp1.models.Cliente;
import com.fundatec.lp1.models.Conta;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ResponseConta {

	private StatusConta status;
	private Cliente cliente;
	private Double saldo;

	public ResponseConta() {

	}

	public ResponseConta(Conta conta) {
		status = conta.getStatus();
		cliente = conta.getCliente();
		saldo = conta.getSaldo();
	}

}
