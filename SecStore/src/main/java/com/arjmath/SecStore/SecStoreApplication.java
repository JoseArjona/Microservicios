package com.arjmath.SecStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient //Habilita el cliente Eureka

//@RibbonClient(name = "StoreRest") //Habilita el balanceador de carga
@EnableFeignClients //Habilita el cliente Feign
@SpringBootApplication
public class SecStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecStoreApplication.class, args);
	}

}
