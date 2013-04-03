package br.com.caelum.parsac.util;

import br.com.caelum.parsac.modelo.Alternativa;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class AlternativaCorretaConverter implements Converter {

	public boolean canConvert(Class clazz) {
		return clazz.equals(Alternativa.class);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {

		Alternativa alternativa = (Alternativa) value;
		writer.startNode("alternativa");
		writer.startNode("texto");
		writer.setValue(alternativa.getTexto());
		writer.endNode();
		writer.endNode();
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {

		Alternativa alternativa = new Alternativa("Op1");
		reader.moveDown();
		reader.moveDown();
		alternativa.setTexto(reader.getValue());
		reader.moveUp();
		return alternativa;

	}

}