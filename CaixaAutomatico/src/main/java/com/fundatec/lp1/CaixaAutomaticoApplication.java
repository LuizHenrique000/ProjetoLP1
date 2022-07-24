package com.fundatec.lp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CaixaAutomaticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaixaAutomaticoApplication.class, args);
	}

}
