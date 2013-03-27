package br.com.caelum.parsac.modelo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("exercicio-multiplaEscolha")
public class MultiplaEscolha extends Exercicio {

	private List<Alternativa> alternativas;

	public MultiplaEscolha(String enunciado, List<Alternativa> alternativas) {
		
		super(enunciado);
		this.alternativas = alternativas;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
	
	public String toString() {
		return this.enunciado + "\n\n" + this.alternativas;
	}
}
