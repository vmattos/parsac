package br.com.caelum.parsac.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.converter.ExerciciosConverter;

import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamConverter(ExerciciosConverter.class)
public class Exercicios {

	private List<Exercicio> exercicios = new ArrayList<Exercicio>();

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
}