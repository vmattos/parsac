package br.com.caelum.parsac.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.ant.AntSetup;
import br.com.caelum.parsac.main.ws.ClienteWS;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Secao;
import br.com.caelum.parsac.parser.ParserAfc;
import br.com.caelum.parsac.xstream.XStreamBuilder;

import com.thoughtworks.xstream.XStream;

public class Main {

	public static void main(String[] args) throws IOException {

		XStream xstream = new XStreamBuilder().processaAnotacoesXStream();

		List<String> listaDeImagens = new ArrayList<String>();

		ClienteWS clienteWS = new ClienteWS();
		String xml = clienteWS
				.consomeWebService("http://www.alura.com.br/webservice/course/php-mysql-e-fundamentos-da-web/AUafs9y8s9fdaA");

		ParserAfc parser = new ParserAfc();

		Curso cursoXML = (Curso) xstream.fromXML(xml);

		AntSetup ant = new AntSetup();

		System.out.println("Criando diretório " + cursoXML.getSigla() + "...");

		ant.setNomeDoDiretorio(cursoXML.getSigla());
		ant.execute();

		for (Secao secao : cursoXML.getSecoes()) {
			String numeroDaSecao = Integer.toString(secao.getNumero());
			if (Integer.parseInt(numeroDaSecao) < 10) {
				numeroDaSecao = "0" + numeroDaSecao;
			}

			String nomeAfc = secao.getTitulo().replaceAll(" ", "-")
					.toLowerCase();

			File arquivoAfc = new File(cursoXML.getSigla() + "/"
					+ numeroDaSecao + "-" + nomeAfc + ".afc");

			BufferedWriter br = new BufferedWriter(new FileWriter(arquivoAfc));

			System.out
					.println("Parseando a seção " + secao.getNumero() + "...");
			String cursoParseado = parser.parseiaCurso(cursoXML,
					Integer.parseInt(numeroDaSecao) - 1);

			br.write(cursoParseado);
			br.close();

			listaDeImagens = parser.pegaLinksDasImagens(secao.getExplicacao());
		}

		System.out.println("Baixando as imagens...");

		ant.setListaDeImagens(listaDeImagens);
		ant.baixaImagens();

		System.out.println("TERMINADO");
	}
}
