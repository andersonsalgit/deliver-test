package br.com.deliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DeliverTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliverTestApplication.class, args);
	}
}
