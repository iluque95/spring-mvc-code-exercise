package com.sinensia.videojuegos.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.videojuegos.backend.business.model.Genero;
import com.sinensia.videojuegos.backend.business.services.GeneroServices;

@RestController
@RequestMapping("generos")
public class GeneroController {
	
	@Autowired
	private GeneroServices generoServices;
	
	@GetMapping
	public List<Genero> obtenerTodos()
	{
		return generoServices.obtenerTodos();
	}
	
}
