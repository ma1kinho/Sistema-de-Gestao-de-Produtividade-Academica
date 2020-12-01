package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Collaborator{

	private String name;
	private String email;
	private String cargo;
	private List<Project> projects = new ArrayList<>();
	private List<AcademicProduction> academicProductions = new ArrayList<>();
	
	public Collaborator() {
	}
	
	public Collaborator(String name, String email, String cargo) {
		this.name = name;
		this.email = email;
		this.cargo = cargo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public List<AcademicProduction> getAcademicProductions() {
		return academicProductions;
	}

	public void addProjectToCollaborator(Project project) {
		projects.add(project);
	}
	
	public void addAcademicProductionToCollaborator(AcademicProduction academicProduction) {
		academicProductions.add(academicProduction);
	}
	
	public void ordCollaboratorPa() {
		Collections.sort(academicProductions);
	}
	
	public void printCollaboratorProjects() {
		System.out.println("Projetos:");
		for(Project p : projects) {
			System.out.println("Titulo do projeto: " + p.getTitle());
			System.out.println("Producao academica feita pelo colaborador sobre este projeto:");
			int qntAp = 0;
			for(AcademicProduction ap : academicProductions) {
				if(ap.getAssociatedProject().equals(p)) {
					System.out.println(ap);
					qntAp += 1;
				}
			}
			if(qntAp == 0) System.out.println("Nenhuma.");
		}
		System.out.println();
	}

	public String toString() {
		return "Nome: " + name + "\nE-mail: " + email;
	}	
}
