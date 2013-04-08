package br.com.caelum.parsac.util;

import br.com.caelum.parsac.modelo.Alternativa;
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
		
		return secao;

	}

}