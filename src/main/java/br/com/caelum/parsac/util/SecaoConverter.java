package br.com.caelum.parsac.util;

import br.com.caelum.parsac.modelo.Aberto;
import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.MultiplaEscolha;
import br.com.caelum.parsac.modelo.Secao;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class SecaoConverter implements Converter {

	public boolean canConvert(Class clazz) {
		return clazz.equals(Secao.class);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {

	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {

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

		while (reader.hasMoreChildren()) {
			reader.moveDown();

			if (reader.getNodeName().equals("exercicio-aberto")) {
				Aberto aberto = new Aberto();
				reader.moveDown();
				aberto.setEnunciado(reader.getValue());
				reader.moveUp();
				reader.moveDown();
				aberto.setResposta(reader.getValue());
				reader.moveUp();

				secao.getAbertos().add(aberto);
			} else if (reader.getNodeName().equals("exercicio-multiplaEscolha")) {
				MultiplaEscolha exercicio = new MultiplaEscolha();

				reader.moveDown();
				exercicio.setEnunciado(reader.getValue());

				reader.moveUp();
				reader.moveDown();
				if (reader.getNodeName().equals("alternativas")) {

					while (reader.hasMoreChildren()) {
						reader.moveDown();
						reader.moveDown();
						exercicio.getAlternativas().add(
								new Alternativa(reader.getValue()));
						reader.moveUp();
						reader.moveUp();

					}
					
					 reader.moveUp();
				}

				else if (reader.getNodeName().equals("resposta")) {
					reader.moveDown();
					reader.moveDown();
					exercicio.setResposta(reader.getValue());
					reader.moveUp();
					reader.moveUp();
				}

				secao.getMultiplaEscolhas().add(exercicio);
			}
			reader.moveUp();
		}

		reader.moveUp();

		return secao;

	}

}