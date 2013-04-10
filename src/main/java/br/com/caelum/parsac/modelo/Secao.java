package br.com.caelum.parsac.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.util.SecaoConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("secao")
@XStreamConverter(SecaoConverter.class)
public class Secao {

	private int numero;
	private String titulo;
	private String explicacao;
	private List<Aberto> abertos = new ArrayList<Aberto>();
	private List<MultiplaEscolha> multiplaEscolhas = new ArrayList<MultiplaEscolha>();

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

	public List<Aberto> getAbertos() {
		return abertos;
	}

	public void setAbertos(List<Aberto> abertos) {
		this.abertos = abertos;
	}

	public List<MultiplaEscolha> getMultiplaEscolhas() {
		return multiplaEscolhas;
	}

	public void setMultiplaEscolhas(List<MultiplaEscolha> multiplaEscolhas) {
		this.multiplaEscolhas = multiplaEscolhas;
	}

	public String toString() {
		return "Seção " + this.numero + ": " + this.titulo + "\n"
				+ this.explicacao + "\n\n" + this.abertos;
	}

}
