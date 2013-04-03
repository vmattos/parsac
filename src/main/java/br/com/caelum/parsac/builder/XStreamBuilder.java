package br.com.caelum.parsac.builder;

import br.com.caelum.parsac.modelo.Aberto;
import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.MultiplaEscolha;

import com.thoughtworks.xstream.XStream;

public class XStreamBuilder {

	public XStream processaAnotacoesXStream() {

		XStream xstream = new XStream();
		xstream.processAnnotations(Curso.class);
		xstream.processAnnotations(Exercicio.class);
		xstream.processAnnotations(Alternativa.class);
		xstream.processAnnotations(Aberto.class);
		xstream.processAnnotations(MultiplaEscolha.class);
		xstream.setMode(XStream.NO_REFERENCES);

		return xstream;
	}

}
