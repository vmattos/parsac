package br.com.caelum.parsac.util;

import br.com.caelum.parsac.modelo.Aberto;
import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Cursos;
import br.com.caelum.parsac.modelo.MultiplaEscolha;
import br.com.caelum.parsac.modelo.Secao;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CursosConverter implements Converter {

	public boolean canConvert(Class clazz) {
		return clazz.equals(Curso.class);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Cursos cursos = (Cursos) value;
		for (Curso curso : cursos.getCursos()) {
			writer.startNode("curso");
			writer.startNode("sigla");
			writer.setValue(String.valueOf(curso.getSigla()));
			writer.endNode();
			writer.startNode("titulo");
			writer.setValue(String.valueOf(curso.getTitulo()));
			writer.endNode();
			writer.startNode("secoes");
			for (Secao secao : curso.getSecoes()) {
				writer.startNode("secao");
				writer.startNode("numero");
				writer.setValue(String.valueOf(secao.getNumero()));
				writer.endNode();
				writer.startNode("titulo");
				writer.setValue(String.valueOf(secao.getTitulo()));
				writer.endNode();
				writer.startNode("explicacao");
				writer.setValue(String.valueOf(secao.getExplicacao()));
				writer.endNode();
			}
		}
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {

		Cursos cursos = new Cursos();

		leCurso(reader, cursos);

		while (!reader.getNodeName().equals("cursos")) {
			reader.moveUp();
		}

		reader.moveDown();
		
		while (reader.hasMoreChildren()) {

			leCurso(reader, cursos);
		}

//		while (!reader.getNodeName().equals("cursos")) {
//			reader.moveUp();
//		}

		return cursos;
	}

	private void leCurso(HierarchicalStreamReader reader, Cursos cursos) {

		Curso curso = new Curso();
		reader.moveDown();
		System.out.println(reader.getNodeName());
		curso.setSigla(reader.getValue());
		reader.moveUp();
		reader.moveDown();
		curso.setTitulo(reader.getValue());
		reader.moveUp();
		reader.moveDown();

		reader.moveDown();

		Secao secao = new Secao();
		reader.moveDown();
		secao.setNumero(Integer.parseInt(reader.getValue()));
		reader.moveUp();
		reader.moveDown();
		secao.setTitulo(reader.getValue());
		reader.moveUp();
		reader.moveDown();
		secao.setExplicacao(reader.getValue());
		reader.moveUp();
		reader.moveDown();
		reader.moveDown();

		if (reader.getNodeName().equals("exercicio-aberto")) {
			Aberto exercicioAberto = new Aberto();
			reader.moveDown();
			exercicioAberto.setEnunciado(reader.getValue());
			reader.moveUp();
			reader.moveDown();
			exercicioAberto.setResposta(reader.getValue());
			reader.moveUp();
			reader.moveUp();

			secao.getExerciciosAbertos().add(exercicioAberto);

		}

		reader.moveDown();

		if (reader.getNodeName().equals("exercicio-multiplaEscolha")) {
			MultiplaEscolha exercicioMultiplaEscolha = new MultiplaEscolha();
			reader.moveDown();
			exercicioMultiplaEscolha.setEnunciado(reader.getValue());
			reader.moveUp();
			reader.moveDown();

			if (reader.getNodeName().equals("alternativas")) {

				while (reader.hasMoreChildren()) {
					reader.moveDown();
					reader.moveDown();
					exercicioMultiplaEscolha.getAlternativas().add(
							new Alternativa(reader.getValue()));
					reader.moveUp();
					reader.moveUp();

				}

				reader.moveUp();
				reader.moveDown();
			}

			if (reader.getNodeName().equals("resposta")) {
				reader.moveDown();
				reader.moveDown();
				exercicioMultiplaEscolha.setResposta(reader.getValue());
				reader.moveUp();
				reader.moveUp();
			}

			secao.getExerciciosMultiplaEscolhas().add(exercicioMultiplaEscolha);
		}

		reader.moveUp();

		curso.getSecoes().add(secao);
		cursos.getCursos().add(curso);
		System.out.println(reader.getNodeName());
	}

}
