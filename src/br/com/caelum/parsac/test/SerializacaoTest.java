package br.com.caelum.parsac.test;

import br.com.caelum.parsac.factory.CursoFactory;
import br.com.caelum.parsac.modelo.Aberto;
import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.MultiplaEscolha;

import com.thoughtworks.xstream.XStream;

public class SerializacaoTest {

	public static void main(String[] args) {

		XStream xstream = new XStream();
		xstream.processAnnotations(Curso.class);
		xstream.processAnnotations(Exercicio.class);
		xstream.processAnnotations(Alternativa.class);
		xstream.processAnnotations(Aberto.class);
		xstream.processAnnotations(MultiplaEscolha.class);

		Curso curso = new CursoFactory().constroiCurso();

		System.out.println(xstream.toXML(curso));

	}

}
