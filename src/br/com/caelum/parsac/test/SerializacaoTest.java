package br.com.caelum.parsac.test;

import br.com.caelum.parsac.builder.XStreamBuilder;
import br.com.caelum.parsac.factory.CursoFactory;
import br.com.caelum.parsac.modelo.Curso;

import com.thoughtworks.xstream.XStream;

public class SerializacaoTest {

	public static void main(String[] args) {

		XStream xstream = new XStreamBuilder().processaAnotacoesXStream();

		Curso curso = new CursoFactory().constroiCurso();

		System.out.println(xstream.toXML(curso));

	}

}
