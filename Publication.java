package entities;

import java.util.ArrayList;
import java.util.List;

public class Publication  extends AcademicProduction {
	private String title;
	private String conferenceName;
	private Integer yearOfPublication;
	private Project associatedProject;
	private List<Collaborator> authors = new ArrayList<>();
	
	public Publication() {	
	}

	public Publication(String title, String conferenceName, int yearOfPublication) {
		super();
		this.title = title;
		this.conferenceName = conferenceName;
		this.yearOfPublication = yearOfPublication;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConferenceName() {
		return conferenceName;
	}

	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}

	public Integer getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public Project getAssociatedProject() {
		return associatedProject;
	}

	public void setAssociatedProject(Project associatedProject) {
		this.associatedProject = associatedProject;
	}
	
	@Override
	public void addAuthor(Collaborator author) {
		authors.add(author);
	}
	
}
