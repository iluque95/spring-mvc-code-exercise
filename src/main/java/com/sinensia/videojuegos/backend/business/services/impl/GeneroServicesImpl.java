package com.sinensia.videojuegos.backend.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sinensia.videojuegos.backend.business.model.Genero;
import com.sinensia.videojuegos.backend.business.services.GeneroServices;

@Component
public class GeneroServicesImpl implements GeneroServices {

	@Override
	public List<Genero> obtenerTodos() {
		
		List<Genero> generos = new ArrayList<>();
		
		for (Genero genero : Genero.values())
		{
			generos.add(genero);
		}
		
		return generos;
		
	}
	
	
	
}
