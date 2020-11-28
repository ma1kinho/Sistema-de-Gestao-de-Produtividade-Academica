package entities;

import java.util.List;

public abstract class Collaborator {
	private String name;
	private String email;
	private String cargo;
	private List<Project> projects;
	private Publication publications;
	
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

	public Publication getPublications() {
		return publications;
	}

	public void setPublications(Publication publications) {
		this.publications = publications;
	}
	
	
}
