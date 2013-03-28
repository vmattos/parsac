package br.com.caelum.parsac.modelo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("secao")
public class Secao {

	private int numero;
	private String titulo;
	private String explicacao;
	private List<Exercicio> exercicios;

	public Secao(int numero, String titulo, String explicacao,
			List<Exercicio> exercicios) {

		this.numero = numero;
		this.titulo = titulo;
		this.explicacao = explicacao;
		this.exercicios = exercicios;
	}

	public int getNumero() {
		return numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getExplicacao() {
		return explicacao;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public String toString() {
		return "Seção " + this.numero + ": " + this.titulo + "\n"
				+ this.explicacao + "\n\n" + this.exercicios;
	}
}
