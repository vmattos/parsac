package br.com.caelum.parsac.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.ExercicioMultiplaEscolha;
import br.com.caelum.parsac.modelo.Secao;

public class ParserAfc {

	private List<String> links = new ArrayList<String>();
	private List<String> respostas = new ArrayList<String>();

	public String parseiaTagsOnline(String string) throws IOException {

		string = string.replaceAll("class=\"linked-list\"", "");

		// Itálico precisa ser parseado antes do negrito, para a ~gambiarra~
		// funcionar
		string = parseiaItalico(string);

		string = parseiaNegrito(string);

		string = parseiaTagCode(string);

		string = parseiaCode(string);

		// string = parseiaLista(string);

		// string = parseiaItemLista(string);

		string = removeTagHr(string);

		// string = removeLinksDeixandoSomenteOTexto(string);

		string = parseiaImagens(string);

		return string;

	}

	private String removeTagHr(String string) {

		string = string.replaceAll("<[ ]*hr[ ]*>", "");
		string = string.replaceAll("<[ ]*hr[ ]*/[ ]*>", "");

		return string;
	}

	private String parseiaImagens(String string) {

		string = string.replaceAll("src=\"http(s)*://[a-z A-Z_0-9./-]*/", "");
		string = string.replaceAll("\"[ ]*alt=\"[a-z A-Z_0-9./-]*", "");
		string = string.replaceAll("\"[ ]*width=\"[a-z A-Z_0-9./-]*", "");
		string = string.replaceAll("img ", "img images/");
		string = string.replaceAll("<[ ]*([a-z A-Z_0-9./-]*)\"(|/| | /)>",
				"[$1]");

		return string;
	}

	private String removeLinksDeixandoSomenteOTexto(String string) {

		string = string
				.replaceAll(
						"<[ ]*a[ ]*href[ ]*=[ ]*\"http(s)*://[a-z A-Z_0-9./-]*\"[ ]*(target=\"_blank\")*>",
						"");
		string = string.replaceAll("<[ ]*/[ ]*a[ ]*>", "");

		return string;
	}

	private String parseiaItemLista(String string) {

		string = string.replaceAll("<[ ]*li[ ]*>", "* ");
		string = string.replaceAll("<[ ]*/[ ]*li[ ]*>", "");

		return string;
	}

	private String parseiaLista(String string) {

		string = string.replaceAll("<[ ]*(ul|ol)[ ]*>", "[list]");
		string = string.replaceAll("<[ ]*/[ ]*(ul|ol)[ ]*>", "[/list]");

		return string;
	}

	private String parseiaItalico(String string) {

		string = string.replaceAll("<[ ]*(em|i)[ ]*>", "::");
		string = string.replaceAll("<[ ]*/[ ]*(em|i)[ ]*>", "::");
		string = string.replaceAll("\\*([^*]+)\\*", "::$1::");

		return string;
	}

	private String parseiaNegrito(String string) {

		string = string.replaceAll("<[ ]*(b|strong|u)[ ]*>", "**");
		string = string.replaceAll("<[ ]*/[ ]*(b|strong|u)[ ]*>", "**");
		string = string.replaceAll("::::", "**");

		return string;
	}

	private String parseiaCode(String string) {

		string = string.replaceAll("<[ ]*code[ ]*>", "%%");
		string = string.replaceAll("<[ ]*/[ ]*code[ ]*>", "%%");
		string = string.replaceAll("`", "%%");

		return string;
	}

	private String parseiaTagCode(String string) {

		for (int i = 0; i < string.length(); i++) {
			string = string.replaceFirst("```", "[code]");

			string = string.replaceFirst("```", "[/code]");
		}

		return string;
	}

	public List<String> pegaLinksDasImagens(String string) {

		Scanner scanner = new Scanner(string);

		while (scanner.hasNext()) {
			String token = scanner.next();

			if (token
					.matches("src=\"http(s)*://[a-z A-Z_0-9./-]*\"((|/)>)*[ ,.]*")) {
				String link = (token.split("\"", 3)[1]);
				links.add(link);
			}
		}

		scanner.close();

		return links;
	}

	public String parseiaCurso(Curso curso, int numeroDaSecao)
			throws IOException {

		Secao secao = curso.getSecoes().get(numeroDaSecao);
		String texto = "[chapter " + secao.getTitulo() + "]";

		System.out.println(">>\tParseando tags da explicação...");

		texto += "\n" + parseiaTagsOnline(secao.getExplicacao());

		System.out.println(">>\tParseando exercicios...");

		texto += "\n\n[section Exercícios]\n\n[exercise]";

		for (Exercicio exercicio : secao.getExercicios().getExercicios()) {
			texto += "\n\t[question]";

			texto += parseiaTagsOnline(exercicio.getEnunciado());
			if (exercicio instanceof ExercicioMultiplaEscolha) {
				texto += "[list]";

				for (Alternativa alternativa : exercicio.getAlternativas()) {
					texto += "\n* " + parseiaTagsOnline(alternativa.getTexto());
				}

				texto += "[/list]";
			}

			texto += "\n[/question]";
			respostas.add(parseiaTagsOnline(exercicio.getResposta()));
		}

		texto += "\n[/exercise]\n[note]\n**Respostas:**\n\n";

		for (int i = 0; i < respostas.size(); i++) {
			texto += i + 1 + ") " + respostas.get(i) + "\n\n";
		}

		texto += "[/note]";

		respostas.clear();

		return texto;
	}

}