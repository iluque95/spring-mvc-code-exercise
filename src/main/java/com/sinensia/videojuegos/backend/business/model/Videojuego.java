package com.sinensia.videojuegos.backend.business.model;

import org.springframework.stereotype.Component;

@Component
public class Videojuego {

	private Long codigo;
	private String titulo;
	private int pegi;
	private boolean multiPlayer;
	public Genero genero;
	
	public Videojuego()
	{
		
	}
	
	public Videojuego(Long codigo, String titulo, int pegi, boolean multiPlayer, Genero genero) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.pegi = pegi;
		this.multiPlayer = multiPlayer;
		this.genero = genero;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getPegi() {
		return pegi;
	}

	public boolean isMultiPlayer() {
		return multiPlayer;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public void setMultiPlayer(boolean multiPlayer) {
		this.multiPlayer = multiPlayer;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Videojuego [codigo=" + codigo + ", titulo=" + titulo + ", pegi=" + pegi + ", multiPlayer=" + multiPlayer
				+ ", genero=" + genero + "]";
	}
	
	
	
}
