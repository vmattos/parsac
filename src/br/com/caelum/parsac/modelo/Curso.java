package br.com.caelum.parsac.modelo;

import java.util.List;

public class Curso {
	
	private String sigla;
	private String titulo;
	private List<Secao> secoes;
	
	public Curso(String sigla, String titulo, List<Secao> secoes) {
		this.sigla = sigla;
		this.titulo = titulo;
		this.secoes = secoes;
	}

	public String getSigla() {
		return sigla;
	}

	public String getTitulo() {
		return titulo;
	}

	public List<Secao> getSecoes() {
		return secoes;
	} 
	
	@Override
	public String toString() {
		return this.sigla + "\nCurso: " + this.titulo + "\n\n" + this.secoes;
	}
}
