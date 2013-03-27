package br.com.caelum.parsac.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("exercicio")
public class Exercicio {

	private Tipo tipo;
	private String enunciado;
	private String resposta;
	private Alternativa alternativa;
	
	public Exercicio(Tipo tipo, String enunciado) {
		
		this.tipo = tipo;
		this.enunciado = enunciado;
	}
	
	public String getResposta() {
		return resposta;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getEnunciado() {
		return enunciado;
	}
}
