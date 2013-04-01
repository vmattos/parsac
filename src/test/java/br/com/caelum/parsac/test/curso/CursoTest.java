package br.com.caelum.parsac.test.curso;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.parsac.factory.CursoFactory;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.MultiplaEscolha;
import br.com.caelum.parsac.modelo.Secao;

public class CursoTest {

	@Test
	public void testaCurso() {

		Curso curso = new CursoFactory().constroiCurso();

		Secao secao = curso.getSecoes().get(0);
		Exercicio exercicioAberto = secao.getExercicios().get(0);
		MultiplaEscolha exercicioMultiplaEscolha = (MultiplaEscolha) secao
				.getExercicios().get(1);

		Assert.assertEquals("FJ-00", curso.getSigla());
		Assert.assertEquals("Formação Teste", curso.getTitulo());
		Assert.assertEquals(1, secao.getNumero());
		Assert.assertEquals("Testes com JUnit", secao.getTitulo());
		Assert.assertEquals("Explicacao da sessao", secao.getExplicacao());
		Assert.assertEquals("Enunciado exercício aberto",
				exercicioAberto.getEnunciado());
		Assert.assertEquals("Enunciado exercício múltipla escolha",
				exercicioMultiplaEscolha.getEnunciado());
		Assert.assertEquals("Op 1", exercicioMultiplaEscolha.getAlternativas()
				.get(0).getTexto());
		Assert.assertEquals("Op 2", exercicioMultiplaEscolha.getAlternativas()
				.get(1).getTexto());
		Assert.assertEquals("Op 1", exercicioMultiplaEscolha.getResposta());

	}

}
