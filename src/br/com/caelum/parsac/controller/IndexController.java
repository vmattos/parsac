package br.com.caelum.parsac.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.parser.ParserAfc;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.thoughtworks.xstream.XStream;

@Resource
public class IndexController {

	private final Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
	}

	@Path("/parseia")
	public String parseia(String path) throws IOException {
		URL url = new URL("http://test-xml.herokuapp.com/");

		InputStreamReader is = new InputStreamReader(url.openStream());
		BufferedReader in = new BufferedReader(is);
		XStream xstream = new XStream();
		xstream.processAnnotations(Curso.class);
		xstream.processAnnotations(Exercicio.class);

		Curso curso = (Curso) xstream.fromXML(in);
		ParserAfc parser = new ParserAfc();

		return parser.parseiaCurso(curso, 1);
	}

}