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
		Project project = new Project();
		
		project.setUserProperty("ant.file", buildFile.getAbsolutePath());
		project.setUserProperty("curso.dir", nomeDoDiretorio);
		
		project.init();
		
		ProjectHelper helper = ProjectHelper.getProjectHelper();
		
		project.addReference("ant.projectHelper", helper);
		
		helper.parse(project, buildFile);
		
		project.executeTarget("prepara-diretorio-curso");
	}
}