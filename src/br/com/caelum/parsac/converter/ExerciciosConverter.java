package br.com.caelum.parsac.converter;

import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.ExercicioAberto;
import br.com.caelum.parsac.modelo.ExercicioMultiplaEscolha;
import br.com.caelum.parsac.modelo.Exercicios;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ExerciciosConverter implements Converter {

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(Exercicios.class);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {

		Exercicios exercicios = new Exercicios();

		while (reader.hasMoreChildren()) {
			reader.moveDown();
			if (reader.getNodeName().equals("exercicio-aberto")) {
				ExercicioAberto exercicio = new ExercicioAberto();

				reader.moveDown();
				exercicio.setNumero(Integer.parseInt(reader.getValue()));
				reader.moveUp();
				reader.moveDown();
				exercicio.setEnunciado(reader.getValue());
				reader.moveUp();
				reader.moveDown();
				exercicio.setResposta(reader.getValue());

				exercicios.getExercicios().add(exercicio);

				reader.moveUp();
			} else {
				ExercicioMultiplaEscolha exercicio = new ExercicioMultiplaEscolha();

				reader.moveDown();
				exercicio.setNumero(Integer.parseInt(reader.getValue()));
				reader.moveUp();
				reader.moveDown();
				exercicio.setEnunciado(reader.getValue());
				reader.moveUp();
				reader.moveDown();

				while (reader.hasMoreChildren()) {
					reader.moveDown();
					reader.moveDown();
					exercicio.getAlternativas().add(
							new Alternativa(reader.getValue()));
					reader.moveUp();
					reader.moveUp();
				}

				reader.moveUp();
				reader.moveDown();
				reader.moveDown();

				exercicio.setResposta(reader.getValue());

				exercicios.getExercicios().add(exercicio);

				reader.moveUp();
				reader.moveUp();
			}
			reader.moveUp();
		}

		return exercicios;

	}
}