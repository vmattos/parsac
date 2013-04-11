package br.com.caelum.parsac.test.curso;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Assert;

import org.junit.Test;

import br.com.caelum.parsac.builder.XStreamBuilder;
import br.com.caelum.parsac.factory.CursoFactory;
import br.com.caelum.parsac.modelo.Curso;

import com.thoughtworks.xstream.XStream;

public class SerializacaoTest {

	@Test
	public void testaSerializacao() throws FileNotFoundException {

		XStream xstream = new XStreamBuilder().processaAnotacoesXStream();

		Curso curso = new CursoFactory().constroiCurso();

		String cursoXml = xstream.toXML(curso);

		String xml = "";

		Scanner sc = new Scanner(new FileReader("teste.xml"));

		while (sc.hasNext()) {
			xml += sc.nextLine() + "\n";
		}
		
		sc.close();

		xml = xml.replaceAll("\t", "");
		xml = xml.replaceAll(" ", "");
		xml = xml.replaceAll("\n", "");
		cursoXml = cursoXml.replaceAll(" ", "");
		cursoXml = cursoXml.replaceAll("\n", "");

		Assert.assertEquals(xml, cursoXml);

	}

}
