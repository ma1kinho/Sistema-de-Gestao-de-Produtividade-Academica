package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Collaborator {
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

	public void addProjectToCollaborator(Project project) {
		projects.add(project);
	}
	
	public void addAcademicProductionToCollaborator(AcademicProduction academicProduction) {
		academicProductions.add(academicProduction);
	}
	
	public String toString() {
		return "Nome: " + name + "\nE-mail: " + email;
	}
}
