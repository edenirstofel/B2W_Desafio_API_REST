package com.b2w.starwars_api.controller;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.b2w.starwars_api.model.Planeta;
import com.b2w.starwars_api.repository.PlanetaRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class PlanetaControllerTest {

	@Autowired
	PlanetaRepository planetaRepository;

	private String id = "1";
	private String nome = "Tatooine";
	private String clima = "arid";
	private String terreno = "desert";
	private int quantidadeAparicao = 5;
	private Planeta planeta1 = new Planeta(id, nome, clima, terreno, quantidadeAparicao);

	@Test
	public void testeInserirPlanetas() {
		planetaRepository.save(planeta1);
	}

	@Test
	public void testeBuscaporId() {
		Optional<Planeta> obj = planetaRepository.findById("Nome");
		Assert.assertNotNull(obj);

	}

	@Test
	public void testeBuscaporNome() {
		testeInserirPlanetas();
		Optional<Planeta> obj = planetaRepository.nome(nome);
		Assert.assertNotNull(obj);
	}

	@Test
	public void testeBuscarTodos() {
		List<Planeta> result = planetaRepository.findAll();
		Assert.assertFalse(result.isEmpty());
	}

	@Test
	public void testeDeleteId() {
		planetaRepository.deleteById(id);

	}
}

