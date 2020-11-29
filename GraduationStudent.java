package entities;

public class GraduationStudent extends Collaborator {	
	private Integer qntProjectsInElaboration = 0;
	
	public GraduationStudent(String name, String email) {
		super(name, email, "GraduationStudent");
	}

	public Integer getQntProjectsInElaboration() {
		return qntProjectsInElaboration;
	}

	public void addQntProjectsInElaboration() {
		qntProjectsInElaboration += 1;
	}

}
