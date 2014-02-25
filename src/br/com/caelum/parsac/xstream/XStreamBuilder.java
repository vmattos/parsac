package br.com.caelum.parsac.xstream;

import antlr.collections.List;
import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.ExercicioAberto;
import br.com.caelum.parsac.modelo.ExercicioMultiplaEscolha;

import com.thoughtworks.xstream.XStream;

public class XStreamBuilder {

	public XStream processaAnotacoesXStream() {

		XStream xstream = new XStream();
		xstream.processAnnotations(Curso.class);
		xstream.processAnnotations(Exercicio.class);
		xstream.processAnnotations(Alternativa.class);
		xstream.processAnnotations(ExercicioAberto.class);
		xstream.processAnnotations(ExercicioMultiplaEscolha.class);
		xstream.alias("cursos", List.class);
		xstream.setMode(XStream.NO_REFERENCES);

		return xstream;
	}

}
