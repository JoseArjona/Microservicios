package com.arjmath.StoreRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //Habilita el cliente Eureka
@SpringBootApplication
public class StoreRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreRestApplication.class, args);
	}

}
