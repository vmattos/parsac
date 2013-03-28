package br.com.caelum.parsac.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("exercicio")
public class Exercicio {

	protected String enunciado;
	protected Alternativa alternativaCorreta;
	private String resposta;

	public Exercicio(String enunciado, Alternativa resposta) {
		this.enunciado = enunciado;
		this.alternativaCorreta = resposta;
	}

	public Exercicio(String enunciado, String resposta) {
		this.enunciado = enunciado;
		this.resposta = resposta;
	}

	public String getEnunciado() {
		return enunciado;
	}
	
	public String getResposta() {
		if (this instanceof Aberto) {
			return resposta;
		} else {
			return alternativaCorreta.getTexto();
		}
	}

}
