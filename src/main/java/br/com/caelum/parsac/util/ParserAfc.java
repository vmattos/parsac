package br.com.caelum.parsac.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Secao;

public class ParserAfc {

	private List<String> linguagens = new ArrayList<String>();
	
	public ParserAfc() {
		linguagens.add("java");
		linguagens.add("xml");
		linguagens.add("html");
		linguagens.add("ruby");
		linguagens.add("js");
		linguagens.add("sql");
		linguagens.add("css");
		linguagens.add("bash");
		linguagens.add("c#");
	}
	
	public String parseiaTagsOnline(String string){

		for (String linguagem : linguagens) {
			string = string.replaceAll(Pattern.quote("[") + "(" + linguagem + ")" + Pattern.quote("]"), "[code " + linguagem + "]");
			string = string.replaceAll(Pattern.quote("[/") + "(" + linguagem + ")" + Pattern.quote("]"), "[/code]");
		}
		
		string = string.replaceAll("<(b|strong|u)>", "**");
		string = string.replaceAll("</(b|strong|u)>", "**");
		
		string = string.replaceAll("<em>", "::");
		string = string.replaceAll("</em>", "::");
		
		string = string.replaceAll("<code>", "%%");
		string = string.replaceAll("</code>", "%%");
		
		string = string.replaceAll("<h1>", "[section ");
		string = string.replaceAll("</h1>", "]");
		
		
		return string;
	}
	
	public String parseiaCurso(Curso curso, int numeroDaSecao) {
		Secao secao = curso.getSecoes().get(numeroDaSecao);
		String texto = "[chapter " + secao.getTitulo() + "]";
		
		texto += "\n" + parseiaTagsOnline(secao.getExplicacao()); 
		
		return texto;
	}
	
}
