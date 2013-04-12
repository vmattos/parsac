package br.com.caelum.parsac.test.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.parsac.modelo.Aberto;
import br.com.caelum.parsac.modelo.Alternativa;
import br.com.caelum.parsac.modelo.Curso;
import br.com.caelum.parsac.modelo.Cursos;
import br.com.caelum.parsac.modelo.Exercicio;
import br.com.caelum.parsac.modelo.MultiplaEscolha;
import br.com.caelum.parsac.modelo.Secao;

public class CursoFactory {

	public Curso constroiCurso() {

		List<Alternativa> alternativasEx2S1 = new ArrayList<Alternativa>();

		alternativasEx2S1.add(new Alternativa("Controller"));
		alternativasEx2S1.add(new Alternativa("View"));
		alternativasEx2S1.add(new Alternativa("Model"));
		alternativasEx2S1.add(new Alternativa(
				"Espalhada em todas as camadas do MVC"));

		Exercicio exercicio1Secao1 = new Aberto(
				"<![CDATA["
						+ "No Eclipse, busque pela aba <code>Servers</code>."
						+ "Selecione <code>New -> Server</code> e escolha a versão do Tomcat. Em seguida,"
						+ "selecione a pasta de instalação do Tomcat, e clique em <code>Next</code>."
						+ "\n"
						+ "Agora basta vincular o novo projeto ao Tomcat. Clique no projeto \"vraptor-produtos\" e"
						+ "depois em <code>Add</code>. Finalize a operação."
						+ "\n"
						+ "Tudo configurado! Agora basta subirmos o Tomcat, clicando no servidor	e escolhendo a "
						+ "opção <code>START</code>. Agora precisamos verificar se a aplicação está de pé. "
						+ "Para isso, basta abrir o seu navegador favorito e digitar a seguinte URL: "
						+ "http://localhost:8080/vraptor-produtos"
						+ "\n"
						+ "Enquanto isso, vamos olhar a saída do Console, mostrando que o VRaptor está subindo."
						+ "Veja a mensagem de \"VRaptor inicializado\", e agora vamos ao Firefox."
						+ "\n"
						+ "Digitando a URL <code>localhost:8080/vraptor-produtos</code>, qual a mensagem que"
						+ "aparece?" +

						"]]>", "Três tigres tristes.");
		Exercicio exercicio2Secao1 = new MultiplaEscolha(
				"No MVC a regra de negócio está em qual camada?",
				alternativasEx2S1, new Alternativa("Model"));

		List<Exercicio> exerciciosSecao1 = new ArrayList<Exercicio>();

		exerciciosSecao1.add(exercicio1Secao1);
		exerciciosSecao1.add(exercicio2Secao1);

		Secao secao1 = new Secao(
				1,
				"Configuração do VRaptor",
				"Bem vindo ao curso de VRaptor da Caelum Ensino e Inovação!"
						+ "\n"
						+ "<h1>Frameworks web Java</h1>"
						+ "Desenvolver aplicações web usando Java é uma das opções mais procuradas pelos programadores,"
						+ "devido à todas as vantagens da plataforma. Muitos frameworks facilitam esse trabalho, e o mais conhecidos"
						+ "são o Struts, o Spring MVC, o  JSF, entre outros."
						+ "Para facilitar ainda mais o desenvolvimento web, a Caelum criou o VRaptor, um framework que faz uso de"
						+ "todas as boas práticas de desenvolvimento recomendadas."
						+ "\n"
						+ "<img src=\"http://s3.amazonaws.com/caelum-online-public/FJ-23/cap-1-vratpor-site.png\" />"
						+ "\n"
						+ "[xml]"
						+ "	<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
						+ "	<web-app ....>"
						+ "		<display-name>vraptor-produtos</display-name>"
						+ "		</filter-mapping>"
						+ "	</web-app>"
						+ "[/xml]"
						+ "\n"
						+ "Note que uma classe de domínio já existe no projeto: O modelo chamado <code>Produto</code>"
						+ "contém <code>nome, descrição, preço</code>." + "\n"
						+ "[java]" + "	public class Produto {"
						+ "		private Long id;" + "}" + "[/java]]]",
				exerciciosSecao1);

		List<Secao> secoes = new ArrayList<Secao>();

		secoes.add(secao1);

		Curso curso = new Curso("FJ-23",
				"VRaptor: web rápida e fácil com java", secoes);

		return curso;
	}
}
