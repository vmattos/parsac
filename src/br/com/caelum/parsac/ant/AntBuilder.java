package br.com.caelum.parsac.ant;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class AntBuilder {

	private String nomeDoDiretorio;

	public String getNomeDoDiretorio() {
		return nomeDoDiretorio;
	}

	public void setNomeDoDiretorio(String nomeDoDiretorio) {
		this.nomeDoDiretorio = nomeDoDiretorio;
	}

	public void build() {
		File buildFile = new File("build.xml");
		Project p = new Project();
		p.setUserProperty("ant.file", buildFile.getAbsolutePath());
		p.setUserProperty("curso.dir", nomeDoDiretorio);
		p.init();
		ProjectHelper helper = ProjectHelper.getProjectHelper();
		p.addReference("ant.projectHelper", helper);
		helper.parse(p, buildFile);
		p.executeTarget("prepara-diretorio-curso");
	}
}
