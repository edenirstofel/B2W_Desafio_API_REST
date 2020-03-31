package com.b2w.starwars_api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.b2w.starwars_api.model.Planeta;
import com.b2w.starwars_api.service.PlanetaService;

@RestController
@RequestMapping(value = "/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;

	@GetMapping
	public ResponseEntity<List<Planeta>> getAllPlaneta() {
		return ResponseEntity.ok().body(planetaService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Planeta>> findById(@PathVariable("id") String id) {
		Optional<Planeta> planeta = planetaService.findById(id);
		if (planeta != null)
			return ResponseEntity.ok(planeta);
		else
			return ResponseEntity.notFound().build();
	}

	@GetMapping(value = "/buscanome")
	public ResponseEntity<List<Planeta>> findByName(@RequestParam(value = "nome") String nome) {
		List<Planeta> listPlaneta = planetaService.findByName(nome);
		if (listPlaneta != null) {
			return new ResponseEntity<>(listPlaneta, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Void> createPlaneta(@RequestBody @Valid Planeta planeta) {
		Planeta planetaSalvo = planetaService.createPlaneta(planeta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(planetaSalvo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deletePlaneta(@PathVariable String id) {
		if (id != null || !id.isEmpty()) {
			planetaService.deletePlaneta(id);
			return ResponseEntity.noContent().build();
		} else {

			return ResponseEntity.notFound().build();
		}

	}

}
