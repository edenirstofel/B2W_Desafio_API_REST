package com.b2w.starwars_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.starwars_api.exception.PlanetaNotFoundException;
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
		encontraPorId(id);
		Optional<Planeta> p = planetaRepository.findById(id);
		return p;
	}

	public Optional<Planeta> findByName(String nome) {
		encontraPorNome(nome);
		Optional<Planeta> p = planetaRepository.nome(nome);
		return p;
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
		planetaRepository.delete(encontraPorId(id));
	}

	public Planeta encontraPorId(String id) {
		Optional<Planeta> obj = planetaRepository.findById(id);
		return obj.orElseThrow(() -> new PlanetaNotFoundException("Id nao encontrado."));
	}

	public Planeta encontraPorNome(String value) {
		Optional<Planeta> obj = planetaRepository.nome(value);
		return obj.orElseThrow(() -> new PlanetaNotFoundException("Planeta nao encontrado."));
	}

}
