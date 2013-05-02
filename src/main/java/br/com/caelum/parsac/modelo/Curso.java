package br.com.caelum.parsac.modelo;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("curso")
public class Curso {

	private String titulo;
	private String sigla;
	private List<Secao> secoes = new ArrayList<Secao>();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}

	public String toString() {
		String string = "Titulo: " + this.titulo + "\nSigla: " + this.sigla;

		for (Secao secao : secoes) {
			string += "\n\nSecao " + secao.getNumero() + ": "
					+ secao.getTitulo() + "\n" + secao.getExplicacao();

			for (Exercicio exercicio : secao.getExercicios().getExercicios()) {
				string += "\n" + exercicio.getEnunciado();
				string += "\n" + exercicio.getResposta();

				if (exercicio instanceof ExercicioMultiplaEscolha) {
					for (Alternativa alternativa : exercicio.getAlternativas()) {
						string += "\n" + alternativa.getTexto();
					}
				}
			}
		}

		return string;
	}

}