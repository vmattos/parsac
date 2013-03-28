package br.com.caelum.parsac.test;

import java.io.File;

import br.com.caelum.parsac.modelo.Aberto;
import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.MultiplaEscolha;

import com.thoughtworks.xstream.XStream;

public class DeserializacaoTest {

	public static void main(String[] args) {
		XStream xstream = new XStream();
		xstream.processAnnotations(Curso.class);
		xstream.processAnnotations(Exercicio.class);
		xstream.processAnnotations(Alternativa.class);
		xstream.processAnnotations(Aberto.class);
		xstream.processAnnotations(MultiplaEscolha.class);

		File xml = new File("teste.xml");

		Curso stringDeserializada = (Curso) xstream
				.fromXML("<?xml version='1.0' encoding='UTF-8'?>  "
						+ "								<curso>" + "									<sigla>FJ-00</sigla>"
						+ "									<titulo>titulo</titulo>"
						+ "									<secoes>" + "										<secao>"
						+ "											<numero>1</numero>"
						+ "											<titulo>Titulo da secao</titulo>"
						+ "											<explicacao>Explicacao</explicacao>"
						+ "											<exercicios>"
						+ "												<exercicio-aberto>"
						+ "													<enunciado>Enunciado</enunciado>"
						+ "													<resposta>La Resposta</resposta>"
						+ "												</exercicio-aberto>"
						+ "												<exercicio-multiplaEscolha>"
						+ "												</exercicio-multiplaEscolha>"
						+ "											</exercicios>" + "										</secao>"
						+ "									</secoes>" + "								</curso>");

		Curso arquivoDeserializado = (Curso) xstream.fromXML(xml);

		System.out.println(arquivoDeserializado);
	}
}
