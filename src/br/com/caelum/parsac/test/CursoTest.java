package br.com.caelum.parsac.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.Secao;
import br.com.caelum.parsac.modelo.Tipo;

import com.thoughtworks.xstream.XStream;

public class CursoTest {

	public static void main(String[] args) throws FileNotFoundException {

		List<Alternativa> alternativasEx2S1 = new ArrayList<Alternativa>();

		alternativasEx2S1.add(new Alternativa("Op 1"));
		alternativasEx2S1.add(new Alternativa("Op 2"));

		Exercicio exercicio1Secao1 = new Exercicio(Tipo.ABERTO, "Enunciado exercício aberto");
		Exercicio exercicio2Secao1 = new Exercicio(Tipo.MULTIPLAESCOLHA, "Enunciado exercício múltipla escolha");

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
		xstream.processAnnotations(Exercicio.class);
		xstream.processAnnotations(Alternativa.class);

		File xml = new File("teste.xml");
//		FileInputStream in = new FileInputStream(xml);
		
//		System.out.println(xstream.fromXML("<?xml version='1.0' encoding='UTF-8'?>  " +
//				"								<curso>" +
//				"									<sigla>FJ-00</sigla>" +
//				"									<titulo>titulo</titulo>" +
//				"									<secoes>" +
//				"										<secao>" +
//				"											<numero>1</numero>" +
//				"											<titulo>Titulo da secao</titulo>" +
//				"											<explicacao>Explicacao</explicacao>" +
//				"											<exercicios>" +
//				"												<exercicio>" +
//				"													<tipo>Aberto</tipo>" +
//				"													<enunciado>" +
//				"														Enunciado" +
//				"													</enunciado>" +
////				"													<resposta>" +
////				"														La Resposta" +
////				"													</resposta>" +
//				"												</exercicio>" +
//				"											</exercicios>" +
//				"										</secao>" +
//				"									</secoes>" +
//				"								</curso>"));
		
		String cursoXml = xstream.toXML(curso);
		System.out.println(cursoXml);
	}
}
