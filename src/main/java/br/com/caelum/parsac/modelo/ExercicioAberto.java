package br.com.caelum.parsac.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("exercicio-aberto")
public class ExercicioAberto extends Exercicio {

	private String resposta;

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}