package com.codecool.el_projecto_grande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ElProjectoGrandeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElProjectoGrandeApplication.class, args);
	}

}
