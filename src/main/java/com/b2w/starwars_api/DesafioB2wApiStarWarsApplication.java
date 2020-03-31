package com.b2w.starwars_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.b2w.starwars_api.model.Planeta;
import com.b2w.starwars_api.repository.PlanetaRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class DesafioB2wApiStarWarsApplication implements CommandLineRunner {

	@Autowired
	private PlanetaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioB2wApiStarWarsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Planeta planeta;
		if (repository.count() == 0) {
			planeta = repository.save(new Planeta(null, null, null, null, null));
			repository.deleteById(planeta.getId());
		}

	}

}