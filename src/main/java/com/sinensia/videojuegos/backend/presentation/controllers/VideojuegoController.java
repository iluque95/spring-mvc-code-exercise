package com.sinensia.videojuegos.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.videojuegos.backend.business.model.Genero;
import com.sinensia.videojuegos.backend.business.model.Videojuego;
import com.sinensia.videojuegos.backend.business.services.VideojuegoServices;

@RestController
@RequestMapping("videojuegos")
public class VideojuegoController {
	
	@Autowired
	public VideojuegoServices videojuegoServices;
	
	@PostMapping
	public Videojuego crear(@RequestBody Videojuego videojuego)
	{
		return videojuegoServices.crear(videojuego);
	}
	
	@PutMapping
	public Videojuego modificar(@RequestBody Videojuego videojuego)
	{
		return videojuegoServices.actualizar(videojuego);
	}
	
	@DeleteMapping("/{codigo}")
	public Videojuego eliminar(@PathVariable Long codigo)
	{
		return videojuegoServices.eliminar(codigo);
	}
	
	@GetMapping("{codigo}")
	public Videojuego obtenerPorCodigo(@PathVariable Long codigo)
	{
		return videojuegoServices.obtenerPorCodigo(codigo);
	}
	
	@GetMapping("genero/{genero}")
	public List<Videojuego> obtenerPorGenero(@PathVariable Genero genero)
	{
		return videojuegoServices.obtenerPorGenero(genero);
	}
	
	@GetMapping
	public List<Videojuego> obtenerFiltrados(@RequestParam (value = "g", required=false) Genero genero)
	{
		List<Videojuego> videojuegos = null;
		
		if (genero == null)
		{
			videojuegos = videojuegoServices.obtenerTodos();
		}
		else
		{
			videojuegos = videojuegoServices.obtenerPorGenero(genero);
		}
		
		return videojuegos;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError> gestionarExcepcion(Exception ex)
	{
		RespuestaError respuestaError = new RespuestaError("Excepción genérica...", "Mirate la documentación hostias !!");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaError);
	}
}

class RespuestaError
{
	private String mensaje;
	private String consejo;
	
	public RespuestaError()
	{
		
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getConsejo() {
		return consejo;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setConsejo(String consejo) {
		this.consejo = consejo;
	}

	@Override
	public String toString() {
		return "RespuestaError [mensaje=" + mensaje + ", consejo=" + consejo + "]";
	}

	public RespuestaError(String mensaje, String consejo) {
		this.mensaje = mensaje;
		this.consejo = consejo;
	}
}
