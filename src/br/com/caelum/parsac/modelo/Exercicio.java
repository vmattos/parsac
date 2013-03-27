package br.com.caelum.parsac.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("exercicio")
public class Exercicio {

	protected String enunciado;
	
	public Exercicio(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public String getEnunciado() {
		return enunciado;
	}
}
