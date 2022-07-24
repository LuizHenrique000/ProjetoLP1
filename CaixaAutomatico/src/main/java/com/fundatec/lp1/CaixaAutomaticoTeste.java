package com.fundatec.lp1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fundatec.lp1.models.Conta;

@FeignClient(value = "conta-consumer", url = "localhost:8080/conta")
public interface CaixaAutomaticoTeste {

	@RequestMapping(method = RequestMethod.GET, value = "")
	Conta getContas();
}
