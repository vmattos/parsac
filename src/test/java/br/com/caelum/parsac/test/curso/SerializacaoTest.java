package br.com.caelum.parsac.test.curso;

import br.com.caelum.parsac.builder.XStreamBuilder;
import br.com.caelum.parsac.factory.CursoFactory;
import br.com.caelum.parsac.modelo.Curso;

import com.thoughtworks.xstream.XStream;

public class SerializacaoTest {

	public static void main(String[] args) {

		XStream xstream = new XStreamBuilder().processaAnotacoesXStream();

		Curso curso = new CursoFactory().constroiCurso();

		System.out.println(xstream.toXML(curso));
		
//		Secao secao = curso.getSecoes().get(0);
//		Exercicio exercicioAberto = secao.getExercicios().get(0);
//		Exercicio exercicioMultiplaEscolha = secao.getExercicios().get(1);
//		List<Alternativa> alternativas = new ArrayList<Alternativa>();
//
//		Assert.assertEquals("FJ-00", curso.getSigla());
//		Assert.assertEquals("Formação Teste", curso.getTitulo());
//		Assert.assertEquals(1, secao.getNumero());
//		Assert.assertEquals("Testes com JUnit", secao.getTitulo());
//		Assert.assertEquals("Explicacao da sessao", secao.getExplicacao());
//		Assert.assertEquals("Enunciado exercício aberto",
//				exercicioAberto.getEnunciado());
//		Assert.assertEquals("Enunciado exercício múltipla escolha", exercicioMultiplaEscolha.getEnunciado());
//		Assert.assertEquals("Op 1", alternativas.get(0).getTexto());
//		Assert.assertEquals("Op 2", alternativas.get(1).getTexto());

	}

}
