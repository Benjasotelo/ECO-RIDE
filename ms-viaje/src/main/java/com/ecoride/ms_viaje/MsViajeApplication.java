package com.ecoride.ms_viaje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsViajeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsViajeApplication.class, args);
	}

}
