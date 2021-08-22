package br.com.orange.carteira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CarteiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarteiraApplication.class, args);
	}

}
