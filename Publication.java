package entities;

import java.util.ArrayList;
import java.util.List;

public class Publication  extends AcademicProduction {

	private String title;
	private String conferenceName;
	private List<Collaborator> authors = new ArrayList<>();
	
	public Publication() {	
	}

	public Publication(String title, String conferenceName, Integer year) {
		super(year);
		this.title = title;
		this.conferenceName = conferenceName;
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
	
	@Override
	public String toString() {
		return  null;
	}
	
}
