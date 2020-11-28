package entities;

import java.util.List;

public abstract class Collaborator {
	private String name;
	private String email;
	private String cargo;
	private List<Project> projects;
	private Publication publications;
	
	public Collaborator(String name, String email, String cargo) {
		this.name = name;
		this.email = email;
		this.cargo = cargo;
	}
	
	
}
