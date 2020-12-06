package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.ProjectStatus;

public abstract class Collaborator{

	private String name;
	private String email;
	private String cargo;
	private List<Project> projects = new ArrayList<>();
	private List<AcademicProduction> academicProductions = new ArrayList<>();
	
	public Collaborator(String name, String email, String cargo) {
		this.name = name;
		this.email = email;
		this.cargo = cargo;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCargo() {
		return cargo;
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
	
	public int qntProjectsInElaboration() {
		int qnt = 0;
		for(Project p : projects) {
			if(p.getStatus().equals(ProjectStatus.IN_ELABORATION)) {
				qnt += 1;
			}
		}	
		return qnt;
	}
	
	public void printCollaboratorProjects() {
		for(Project p : projects) {
			System.out.println("Titulo do projeto: " + p.getTitle());
		}
	}
	
	public void printCollaboratorAcademicProductions() {
		for(AcademicProduction ap : academicProductions) {
			if(ap instanceof Publication) {
				System.out.println("Titulo da publicacao: " + ap.getTitle());
				System.out.println("Ano da publicacao: " + ap.getYear());
			} else {
				System.out.println("Titulo da orientacao: " + ap.getTitle());
				System.out.println("Ano da orientacao: " + ap.getYear());
			}
		}
	}

	public String toString() {
		return "Nome: " + name + "\nE-mail: " + email;
	}	
}