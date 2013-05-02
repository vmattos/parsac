package br.com.caelum.parsac.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("secao")
public class Secao {

	private int numero;
	private String titulo;
	private String explicacao;
	private Exercicios exercicios;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(String explicacao) {
		this.explicacao = explicacao;
	}

	public Exercicios getExercicios() {
		return exercicios;
	}

	public void setExercicios(Exercicios exercicios) {
		this.exercicios = exercicios;
	}

}