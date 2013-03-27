package br.com.caelum.parsac.test;

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

		Exercicio exercicio1Secao1 = new Aberto("Enunciado exercicio 1",
				"Resposta exercicio 1");
		Exercicio exercicio2Secao1 = new MultiplaEscolha(
				"Enunciado exercicio 2", alternativasEx2S1);

		List<Exercicio> exerciciosSecao1 = new ArrayList<Exercicio>();

		exerciciosSecao1.add(exercicio1Secao1);
		exerciciosSecao1.add(exercicio2Secao1);

		Secao secao1 = new Secao(1, "Testes com JUnit", "Explicacao da sessao",
				exerciciosSecao1);
		// Secao secao2 = new Secao(2, "Secao 2", "Explicacao da secao",
		// exerciciosSecao2);
		// Secao secao3 = new Secao(3, "Secao 3", "Explicacao da secao",
		// exerciciosSecao3);

		List<Secao> secoes = new ArrayList<Secao>();

		secoes.add(secao1);

		Curso curso = new Curso("FJ-00", "Formação Teste", secoes);

		// System.out.println(curso);

		XStream xstream = new XStream();
		xstream.processAnnotations(Curso.class);
		xstream.processAnnotations(Aberto.class);
		xstream.processAnnotations(MultiplaEscolha.class);

		// File xml = new File("teste.xml");
		// new FileInputStream(xml);

		// System.out.println(xstream.fromXML("<?xml version='1.0' encoding='UTF-8'?> <attr1>a</attr1>"));

		String cursoXml = xstream.toXML(curso);
		System.out.println(cursoXml);
	}
}
