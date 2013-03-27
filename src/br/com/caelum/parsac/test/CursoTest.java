package br.com.caelum.parsac.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.modelo.Aberto;
import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.MultiplaEscolha;
import br.com.caelum.parsac.modelo.Secao;

import com.thoughtworks.xstream.XStream;

public class CursoTest {

	public static void main(String[] args) throws FileNotFoundException {

		List<Alternativa> alternativasEx2S1 = new ArrayList<Alternativa>();

		alternativasEx2S1.add(new Alternativa("Op 1"));
		alternativasEx2S1.add(new Alternativa("Op 2"));

		Exercicio exercicio1Secao1 = new Aberto("Enunciado exercício aberto", "Resposta");
		Exercicio exercicio2Secao1 = new MultiplaEscolha("Enunciado exercício múltipla escolha", alternativasEx2S1);

		List<Exercicio> exerciciosSecao1 = new ArrayList<Exercicio>();

		exerciciosSecao1.add(exercicio1Secao1);
		exerciciosSecao1.add(exercicio2Secao1);

		Secao secao1 = new Secao(1, "Testes com JUnit", "Explicacao da sessao",
				exerciciosSecao1);

		List<Secao> secoes = new ArrayList<Secao>();

		secoes.add(secao1);

		Curso curso = new Curso("FJ-00", "Formação Teste", secoes);

		System.out.println(curso);
	}
}
