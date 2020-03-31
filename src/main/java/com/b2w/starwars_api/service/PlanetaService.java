package com.b2w.starwars_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.starwars_api.model.Planeta;
import com.b2w.starwars_api.repository.PlanetaRepository;

@Service
public class PlanetaService {

	private PlanetaRepository planetaRepository;
	@Autowired
	private SwapApiRestPlanetaService swapApiService;

	@Autowired
	public PlanetaService(PlanetaRepository planetaRepository) {
		this.planetaRepository = planetaRepository;
	}

	public List<Planeta> findAll() {
		return planetaRepository.findAll();
	}

	public Optional<Planeta> findById(String id) {
		Optional<Planeta> p = planetaRepository.findById(id);

		if (p == null) {
			return null;
		}
		return p;
	}

	public List<Planeta> findByName(String nome) {

		return planetaRepository.nome(nome);
	}

	public Planeta createPlaneta(Planeta planeta) {
		Integer quantidadeAparicao = swapApiService.swapiRestPlanetaAparicoes(planeta.getNome());
		if (quantidadeAparicao == null) {
			return null;
		}
		planeta.setQuantidadeAparicao(quantidadeAparicao);
		return planetaRepository.save(planeta);
	}

	public void deletePlaneta(String id) {
		planetaRepository.deleteById(id);
	}
}
