package com.b2w.starwars_api.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class SwapApiRestPlanetaService {

	@Value("${url_swapi_api}")
	private String SWAPI_API_URL;

	public Integer swapiRestPlanetaAparicoes(String nomeFilmes) {
		int qtdAparicao = 0;
		
		StringBuilder completeUrl = new StringBuilder();
		completeUrl.append(SWAPI_API_URL).append(nomeFilmes);

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		Object object;

		try {
			object = restTemplate.exchange(completeUrl.toString(), HttpMethod.GET,
					new HttpEntity<String>("parameters", headers), Object.class);
		} catch (Exception e) {
			e.getStackTrace();
			return qtdAparicao;
		}

		Gson gson = new Gson();
		JsonArray results = gson.fromJson(gson.toJson(object), JsonObject.class).getAsJsonObject("body")
				.getAsJsonArray("results");

		JsonElement correctResult = null;

		for (JsonElement e : results) {
			if (e.getAsJsonObject().get("name").getAsString().equalsIgnoreCase(nomeFilmes)) {
				correctResult = e;
			}

		}

		if (correctResult == null) {
			return qtdAparicao;
		} else {
			qtdAparicao = correctResult.getAsJsonObject().getAsJsonArray("films").size();
			return qtdAparicao;

		}

	}
}
