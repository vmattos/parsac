package br.com.caelum.parsac.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("exercicio-aberto")
public class Aberto extends Exercicio {

	private String resposta;

	public Aberto() {
	}

	public Aberto(String enunciado, String resposta) {
		super(enunciado, resposta);
		this.resposta = resposta;
	}
	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getResposta() {
		return resposta;
	}

	public String toString() {
		return this.enunciado + "\n\n" + this.resposta;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
}
