package br.com.caelum.parsac.modelo;

import java.util.List;

import br.com.caelum.parsac.util.alternativaCorretaConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("exercicio-multiplaEscolha")
public class MultiplaEscolha extends Exercicio {

	private List<Alternativa> alternativas;
	
	@XStreamConverter(alternativaCorretaConverter.class)
	private Alternativa resposta;

	public MultiplaEscolha(String enunciado, List<Alternativa> alternativas,
			Alternativa resposta) {
		super(enunciado, resposta);
		this.alternativas = alternativas;
		this.resposta = resposta;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public String getResposta() {
		return this.resposta.getTexto();
	}

	public String toString() {
		return this.enunciado + "\n\n" + this.alternativas + "\nResposta: "
				+ this.resposta;
	}

}
