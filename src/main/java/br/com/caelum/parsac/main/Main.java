package br.com.caelum.parsac.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import br.com.caelum.parsac.builder.XStreamBuilder;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Secao;
import br.com.caelum.parsac.util.AntBuilder;
import br.com.caelum.parsac.util.ParserAfc;

import com.thoughtworks.xstream.XStream;

public class Main {

	public static void main(String[] args) throws IOException {

		XStream xstream = new XStreamBuilder().processaAnotacoesXStream();
		File xml = new File("teste.xml");
		ParserAfc parser = new ParserAfc();
		Curso arquivoDeserializado = (Curso) xstream.fromXML(xml);
		
		AntBuilder ant = new AntBuilder();
		ant.setNomeDoDiretorio(arquivoDeserializado.getSigla());
		ant.build();

		for (Secao secao : arquivoDeserializado.getSecoes()) {
			int numeroDaSecao = secao.getNumero();

			String nomeAfc = secao.getTitulo().replaceAll(" ", "-")
					.toLowerCase();

			File arquivoAfc = new File("curso/" + numeroDaSecao + "-" + nomeAfc + ".afc");

			BufferedWriter br = new BufferedWriter(new FileWriter(arquivoAfc));

			String cursoParseado = parser.parseiaCurso(arquivoDeserializado,
					numeroDaSecao - 1);

			System.out.println(cursoParseado);

			br.write(cursoParseado);
			br.close();
		}

	}
}
