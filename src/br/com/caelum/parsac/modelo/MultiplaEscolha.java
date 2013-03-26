package br.com.caelum.parsac.modelo;

import java.util.List;

public class MultiplaEscolha extends Exercicio {

	private List<String> alternativas;

	public MultiplaEscolha(String enunciado, List<String> alternativas) {
		
		super("Multiplaescolha", enunciado);
		this.alternativas = alternativas;
	}

	public List<String> getAlternativas() {
		return alternativas;
	}
	
	public String toString() {
		return this.enunciado + "\n" + this.alternativas;
	}
}
