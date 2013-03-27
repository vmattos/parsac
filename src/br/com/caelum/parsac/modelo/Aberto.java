package br.com.caelum.parsac.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("exercicio")
public class Aberto extends Exercicio {
	
	private String resposta;

	public Aberto(String enunciado, String resposta) {
		super("Aberto", enunciado);
		this.resposta = resposta;
	}

	public String getResposta() {
		return resposta;
	}
	
	public String toString() {
		return this.enunciado + "\n";
	}
}
