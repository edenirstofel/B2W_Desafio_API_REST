package com.b2w.starwars_api.exception;

public class PlanetaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlanetaNotFoundException(String ex) {
		super(ex);
	}

}
