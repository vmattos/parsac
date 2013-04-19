package br.com.caelum.parsac.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.util.CursosConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("cursos")
public class Cursos {

	@XStreamOmitField
	private List<Curso> cursos = new ArrayList<Curso>();

	public Cursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Cursos() {

	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
