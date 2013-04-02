package br.com.caelum.parsac.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.modelo.Aberto;
import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.MultiplaEscolha;
import br.com.caelum.parsac.modelo.Secao;

public class CursoFactory {

	public Curso constroiCurso() {

		List<Alternativa> alternativasEx2S1 = new ArrayList<Alternativa>();

		alternativasEx2S1.add(new Alternativa("Controller"));
		alternativasEx2S1.add(new Alternativa("View"));
		alternativasEx2S1.add(new Alternativa("Model"));
		alternativasEx2S1.add(new Alternativa("Espalhada em todas as camadas do MVC"));

		Exercicio exercicio1Secao1 = new Aberto("Enquanto isso, vamos olhar a saída do Console, mostrando que o VRaptor está subindo. Veja a mensagem de VRaptor inicializado, e agora vamos ao Firefox.",
				"Batata");
		Exercicio exercicio2Secao1 = new MultiplaEscolha(
				"No MVC a regra de negócio está em qual camada?", alternativasEx2S1,
				new Alternativa("Alternativa A"));

		List<Exercicio> exerciciosSecao1 = new ArrayList<Exercicio>();

		exerciciosSecao1.add(exercicio1Secao1);
		exerciciosSecao1.add(exercicio2Secao1);

		Secao secao1 = new Secao(1, "Configuração do VRaptor", "Bem vindo ao curso de VRaptor da Caelum Ensino e Inovação!",
				exerciciosSecao1);

		List<Secao> secoes = new ArrayList<Secao>();

		secoes.add(secao1);

		Curso curso = new Curso("FJ-23", "VRaptor: web rápida e fácil com java", secoes);

		return curso;
	}
}
