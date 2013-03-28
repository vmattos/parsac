package br.com.caelum.parsac.test;

import java.io.FileNotFoundException;

import br.com.caelum.parsac.factory.CursoFactory;
import br.com.caelum.parsac.modelo.Curso;

public class CursoTest {

	public static void main(String[] args) throws FileNotFoundException {

		Curso curso = new CursoFactory().constroiCurso();

		System.out.println(curso);
	}
}
