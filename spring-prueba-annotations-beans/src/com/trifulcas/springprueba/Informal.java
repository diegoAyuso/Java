package com.trifulcas.springprueba;

import org.springframework.stereotype.Component;

@Component
public class Informal implements ISaludo {

	@Override
	public String hola() {
		// TODO Auto-generated method stub
		return "�Qu� pasa en tu casa?";
	}

	@Override
	public String adios() {
		// TODO Auto-generated method stub
		return "Chao, pescao";
	}

}
