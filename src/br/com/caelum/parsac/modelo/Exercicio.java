package br.com.caelum.parsac.modelo;

public class Exercicio {

	protected String tipo;
	protected String enunciado;
	
	public Exercicio(String tipo, String enunciado) {
		
		this.tipo = tipo;
		this.enunciado = enunciado;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEnunciado() {
		return enunciado;
	}
}
