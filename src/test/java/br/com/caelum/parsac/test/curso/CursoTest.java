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

		Assert.assertEquals("FJ-23", curso.getSigla());
		Assert.assertEquals("VRaptor: web rápida e fácil com java",
				curso.getTitulo());
		Assert.assertEquals(1, secao.getNumero());
		Assert.assertEquals("Configuração do VRaptor", secao.getTitulo());
		Assert.assertEquals(
				"Bem vindo ao curso de VRaptor da Caelum Ensino e Inovação!",
				secao.getExplicacao());
		Assert.assertEquals(
				"Enquanto isso, vamos olhar a saída do Console, mostrando que o VRaptor está subindo. Veja a mensagem de \"VRaptor inicializado\", e agora vamos ao Firefox.",
				exercicioAberto.getEnunciado());
		Assert.assertEquals("Batata", exercicioAberto.getResposta());
		Assert.assertEquals("No MVC a regra de negócio está em qual camada?",
				exercicioMultiplaEscolha.getEnunciado());
		Assert.assertEquals("Controller", exercicioMultiplaEscolha
				.getAlternativas().get(0).getTexto());
		Assert.assertEquals("View", exercicioMultiplaEscolha.getAlternativas()
				.get(1).getTexto());
		Assert.assertEquals("Model", exercicioMultiplaEscolha.getAlternativas()
				.get(2).getTexto());
		Assert.assertEquals("Espalhada em todas as camadas do MVC",
				exercicioMultiplaEscolha.getAlternativas().get(3).getTexto());
		Assert.assertEquals("Alternativa A",
				exercicioMultiplaEscolha.getResposta());

	}

}
