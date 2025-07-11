package br.com.cotiinformatica;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class PedidosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidosApiApplication.class, args);
	}

}
