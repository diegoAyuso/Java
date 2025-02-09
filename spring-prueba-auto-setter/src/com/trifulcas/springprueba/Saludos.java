package com.trifulcas.springprueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("miSaludo")
public class Saludos {

	@Autowired
	private ISaludo _saludo;

	public String hola() {
		return _saludo.hola();
	}
	public String adios() {
		return _saludo.adios();
	}
	
}
