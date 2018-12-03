package br.com.compasso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CompassoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompassoTestApplication.class, args);
	}
}
