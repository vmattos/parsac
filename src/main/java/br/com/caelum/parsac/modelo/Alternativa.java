package br.com.caelum.parsac.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("alternativa")
public class Alternativa {

	private String texto;

	public Alternativa() {
	}

	public Alternativa(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String toString() {
		return this.texto;
	}

}
