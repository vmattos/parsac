package br.com.caelum.parsac.test;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.modelo.Aberto;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.MultiplaEscolha;
import br.com.caelum.parsac.modelo.Secao;

public class CursoTest {

	public static void main(String[] args) {

		List<String> alternativasEx2S1 = new ArrayList<String>();

		alternativasEx2S1.add("Op 1");
		alternativasEx2S1.add("Op 2");

		Exercicio exercicio1Secao1 = new Aberto("Enunciado exercicio 1",
				"Resposta exercicio 1");
		Exercicio exercicio2Secao1 = new MultiplaEscolha(
				"Enunciado exercicio 2", alternativasEx2S1);

		List<Exercicio> exerciciosSecao1 = new ArrayList<Exercicio>();

		exerciciosSecao1.add(exercicio1Secao1);
		exerciciosSecao1.add(exercicio2Secao1);

		Secao secao1 = new Secao(
				1,
				"Testes com JUnit",
				"Com certeza, todo desenvolvedor de software já escreveu um trecho de código que não funcionava. \n" +
				"E pior, muitas vezes só descobrimos que o código não funciona quando nosso cliente nos reporta o bug. \n" +
				"Nesse momento, perdemos a confiança no nosso código (já que o número de bugs é alto) e o cliente perde a confiança na equipe \n" +
				"de desenvolvimento (já que ela não entrega código de qualidade). Mas será que isso é difícil de acontecer? \n" +
				"Para exemplificar isso, imagine que hoje trabalhamos em um sistema de leilão. Nesse sistema, \n" +
				"um determinado trecho de código é responsável por devolver o maior lance de um leilão. Veja a \n" +
				"implementação deste código:",
				exerciciosSecao1);
		// Secao secao2 = new Secao(2, "Secao 2", "Explicacao da secao",
		// exerciciosSecao2);
		// Secao secao3 = new Secao(3, "Secao 3", "Explicacao da secao",
		// exerciciosSecao3);

		List<Secao> secoes = new ArrayList<Secao>();

		secoes.add(secao1);

		Curso curso = new Curso("FJ-00", "Formação Teste", secoes);

		System.out.println(curso);
	}
}
