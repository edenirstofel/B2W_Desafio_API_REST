package com.b2w.starwars_api.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "id", "nome", "clima", "terreno", "quantidadeAparicao" })

public class Planeta {

	@Id
	private String id; //
	@NotBlank(message= "O campo nome nao pode esta vazio")
	private String nome; //
	@NotBlank(message= "O campo clima nao pode esta vazio")
	private String clima; //
	@NotBlank(message= "O campo terreno nao pode esta vazio")
	private String terreno; //

	private Integer quantidadeAparicao; //



	public Planeta(String id, @NotBlank String nome, @NotBlank String clima, @NotBlank String terreno, Integer quantidadeAparicao) { //
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.quantidadeAparicao = quantidadeAparicao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	
	public Integer getQuantidadeAparicao() {
		return quantidadeAparicao;
	}

	public void setQuantidadeAparicao(Integer quantidadeAparicao) {
		this.quantidadeAparicao = quantidadeAparicao;
	}

	@Override
	public String toString() {
		return "planeta [id=" + id + ", nome=" + nome + ", clima=" + clima + ", terreno=" + terreno + ", quantidadeAparicao="
				+ quantidadeAparicao + "]";
	}
	
	

}
