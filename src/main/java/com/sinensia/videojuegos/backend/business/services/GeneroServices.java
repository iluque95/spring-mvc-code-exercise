package com.sinensia.videojuegos.backend.business.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sinensia.videojuegos.backend.business.model.Genero;

@Repository
public interface GeneroServices {
	
	public List<Genero> obtenerTodos();
	
}