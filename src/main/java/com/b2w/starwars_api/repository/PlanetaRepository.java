package com.b2w.starwars_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.b2w.starwars_api.model.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {

	public List<Planeta> nome(String nome); }