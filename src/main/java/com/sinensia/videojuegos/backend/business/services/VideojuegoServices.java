package com.sinensia.videojuegos.backend.business.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sinensia.videojuegos.backend.business.model.Genero;
import com.sinensia.videojuegos.backend.business.model.Videojuego;

@Repository
public interface VideojuegoServices {
	
	/**
	 * Dado un juego, se crea en el sistema
	 * 
	 */
	public Videojuego crear(Videojuego videojuego);
	
	public List<Videojuego> obtenerTodos();
	
	public Videojuego obtenerPorCodigo(Long codigo);
	
	public List<Videojuego> obtenerPorGenero(Genero genero);
	
	public Videojuego actualizar(Videojuego videojuego);
	
	public Videojuego eliminar(Long codigo);

	
}
