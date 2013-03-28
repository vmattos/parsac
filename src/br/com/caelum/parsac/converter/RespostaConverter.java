package br.com.caelum.parsac.converter;

import java.util.List;

import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class RespostaConverter implements Converter {

	@Override
	public boolean canConvert(Class clazz) {
		return true;
	}

	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		
		List<Alternativa> alternativas= (List<Alternativa>) obj;
		
		for (Alternativa alternativa : alternativas) {
			writer.startNode("alternativa");
			writer.startNode("texto");
			writer.setValue(alternativa.getTexto());
			writer.endNode();
			writer.endNode();
		}
			writer.startNode("resposta");
			writer.startNode("alternativa");
			writer.startNode("texto");
			writer.setValue(alternativas.get(0).getTexto());
			writer.endNode();
			writer.endNode();
		
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		return context.convertAnother(context.currentObject(), List.class);
	}

}
