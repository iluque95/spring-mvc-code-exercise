package com.sinensia.videojuegos.backend.business.services.impl;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sinensia.videojuegos.backend.business.model.Genero;
import com.sinensia.videojuegos.backend.business.model.Videojuego;
import com.sinensia.videojuegos.backend.business.services.VideojuegoServices;

@Service
public class VideojuegoServicesImpl implements VideojuegoServices {
	
	private static final TreeMap<Long, Videojuego> VIDEOJUEGOS = new TreeMap<>();

	@Override
	public Videojuego crear(Videojuego videojuego) {
		
		if (videojuego == null)
			throw new IllegalArgumentException("No se admiten videojuegos vacíos !!");
		
		VIDEOJUEGOS.put(videojuego.getCodigo(), videojuego);
		
		return videojuego;
	}

	@Override
	public List<Videojuego> obtenerTodos() {
		return VIDEOJUEGOS.values().stream()
				.collect(Collectors.toList());
	}

	@Override
	public Videojuego obtenerPorCodigo(Long codigo) {
		return VIDEOJUEGOS.get(codigo);
	}

	@Override
	public List<Videojuego> obtenerPorGenero(Genero genero) {
		return VIDEOJUEGOS.values().stream()
				.filter(v -> v.getGenero() == genero)
				.collect(Collectors.toList());
	}

	@Override
	public Videojuego actualizar(Videojuego videojuego) {
		
		crear(videojuego);
		
		return videojuego;
	}

	@Override
	public Videojuego eliminar(Long codigo) {
		
		if (VIDEOJUEGOS.containsKey(codigo))
		{
			Videojuego videojuego = VIDEOJUEGOS.get(codigo);
			VIDEOJUEGOS.remove(codigo);
			return videojuego;
		}
		
		return null;
	}
}
