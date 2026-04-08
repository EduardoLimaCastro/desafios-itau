package com.desafio.itau;

import org.springframework.boot.SpringApplication;

public class TestItauApplication {

	public static void main(String[] args) {
		SpringApplication.from(ItauApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
