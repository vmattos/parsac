package br.com.caelum.parsac.test.curso;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.parser.ParserAfc;
import br.com.caelum.parsac.test.factory.CursoFactory;
import br.com.caelum.parsac.xstream.XStreamBuilder;

import com.thoughtworks.xstream.XStream;

public class SerializacaoTest {

	@Test
	public void testaSerializacao() throws IOException {

		XStream xstream = new XStreamBuilder().processaAnotacoesXStream();

		Curso curso = new CursoFactory().constroiCurso();

		String cursoXml = xstream.toXML(curso);
		
		String xml = "";
		
		ParserAfc afc = new ParserAfc();

		Scanner sc = new Scanner(new FileReader("curso.xml"));

		while (sc.hasNext()) {
			xml += sc.nextLine() + "\n";
		}

		sc.close();
		
		System.out.println(afc.parseiaTagsOnline(xml));
//
//		xml = xml.replaceAll("\t", "");
//		xml = xml.replaceAll(" ", "");
//		xml = xml.replaceAll("\n", "");
//		cursoXml = cursoXml.replaceAll(" ", "");
//		cursoXml = cursoXml.replaceAll("\n", "");
//
//		Assert.assertEquals(xml, cursoXml);
		
//		System.out.println(cursoXml);

	}

}
