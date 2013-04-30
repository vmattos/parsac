package br.com.caelum.parsac.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.util.CursoConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("secao")
public class Secao {

	private int numero;
	private String titulo;
	private String explicacao;
	private List<Aberto> exerciciosAbertos = new ArrayList<Aberto>();
	private List<MultiplaEscolha> exerciciosMultiplaEscolhas = new ArrayList<MultiplaEscolha>();

	public Secao() {
	}

	public Secao(int numero, String titulo, String explicacao,
			List<Exercicio> exercicios) {

		this.numero = numero;
		this.titulo = titulo;
		this.explicacao = explicacao;
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

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setExplicacao(String explicacao) {
		this.explicacao = explicacao;
	}

	public List<Aberto> getExerciciosAbertos() {
		return exerciciosAbertos;
	}

	public void setExerciciosAbertos(List<Aberto> exerciciosAbertos) {
		this.exerciciosAbertos = exerciciosAbertos;
	}

	public List<MultiplaEscolha> getExerciciosMultiplaEscolhas() {
		return exerciciosMultiplaEscolhas;
	}

	public void setExerciciosMultiplaEscolhas(
			List<MultiplaEscolha> exerciciosMultiplaEscolhas) {
		this.exerciciosMultiplaEscolhas = exerciciosMultiplaEscolhas;
	}

	public String toString() {
		return "Seção " + this.numero + ": " + this.titulo + "\n"
				+ this.explicacao + "\n\n" + this.exerciciosAbertos;
	}

}
