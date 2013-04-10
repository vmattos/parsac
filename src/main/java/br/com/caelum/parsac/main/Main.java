package br.com.caelum.parsac.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.caelum.parsac.builder.XStreamBuilder;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Secao;
import br.com.caelum.parsac.util.AntSetup;
import br.com.caelum.parsac.util.ParserAfc;

import com.thoughtworks.xstream.XStream;

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("PARSAC");

		XStream xstream = new XStreamBuilder().processaAnotacoesXStream();
		File xml = new File("teste.xml");
		ParserAfc parser = new ParserAfc();
		Curso arquivoDeserializado = (Curso) xstream.fromXML(xml);
		
		
		AntSetup ant = new AntSetup();
		System.out.println("Criando diretorio " + arquivoDeserializado.getSigla() + "...");
		ant.setNomeDoDiretorio(arquivoDeserializado.getSigla());
		ant.execute();

		for (Secao secao : arquivoDeserializado.getSecoes()) {
			int numeroDaSecao = secao.getNumero();

			String nomeAfc = secao.getTitulo().replaceAll(" ", "-")
					.toLowerCase();

			File arquivoAfc = new File(arquivoDeserializado.getSigla() + "/" + numeroDaSecao + "-" + nomeAfc + ".afc");

			BufferedWriter br = new BufferedWriter(new FileWriter(arquivoAfc));

			System.out.println("Parseando a secao " + secao.getNumero() + "...");
			String cursoParseado = parser.parseiaCurso(arquivoDeserializado,
					numeroDaSecao - 1);

			br.write(cursoParseado);
			br.close();
			
			System.out.println("Baixando as imagens...");
			List<String> listaDeImagens = parser.pegaLinksDasImagens(secao.getExplicacao());
			ant.setListaDeImagens(listaDeImagens);
			ant.baixaImagens();
			
		}
		
		System.out.println("Terminado.");

	}
}
