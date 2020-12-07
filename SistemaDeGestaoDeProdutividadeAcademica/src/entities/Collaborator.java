package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.ProjectStatus;

public abstract class Collaborator{

	private String name;
	private String email;
	private List<Project> projects = new ArrayList<>();
	private List<AcademicProduction> academicProductions = new ArrayList<>();
	
	public Collaborator(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
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
			System.out.println(p);
		}
	}
	
	public void printCollaboratorAcademicProductions() {
		for(AcademicProduction ap : academicProductions) {
			System.out.println(ap);
		}
	}

	public String toString() {
		return "Nome: " + name + "\nE-mail: " + email;
	}	
}
