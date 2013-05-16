package br.com.caelum.parsac.ant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class AntSetup {

	private String nomeDoDiretorio;
	private File buildFile = new File("build.xml");
	private Project p = new Project();
	private List<String> listaDeImagens = new ArrayList<String>();

	public String getNomeDoDiretorio() {
		return nomeDoDiretorio;
	}

	public void setNomeDoDiretorio(String nomeDoDiretorio) {
		this.nomeDoDiretorio = nomeDoDiretorio;
	}

	public void baixaImagens() {
		for (String imagem : listaDeImagens) {
			p.setUserProperty("img.url", imagem);
			System.out.println(">>\t" + imagem);
			p.executeTarget("baixa-imagens");
		}
	}

	public List<String> getListaDeImagens() {
		return listaDeImagens;
	}

	public void setListaDeImagens(List<String> listaDeImagens) {
		this.listaDeImagens = listaDeImagens;
	}

	public void execute() {
		p.setUserProperty("ant.file", buildFile.getAbsolutePath());
		p.setUserProperty("curso.dir", nomeDoDiretorio);
		p.init();
		ProjectHelper helper = ProjectHelper.getProjectHelper();
		p.addReference("ant.projectHelper", helper);
		helper.parse(p, buildFile);
		p.executeTarget("prepara-diretorio-curso");
	}

}
