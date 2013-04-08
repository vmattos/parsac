package br.com.caelum.parsac.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
	
	public String parseia(String string){

		for (String linguagem : linguagens) {
			string = string.replaceAll(Pattern.quote("[") + "(" + linguagem + ")" + Pattern.quote("]"), "[code " + linguagem + "]");
			string = string.replaceAll(Pattern.quote("[/") + "(" + linguagem + ")" + Pattern.quote("]"), "[/code]");
		}
		
		
		return string;
	}
}
