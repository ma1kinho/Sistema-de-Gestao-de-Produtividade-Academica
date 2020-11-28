package entities;

import java.util.ArrayList;
import java.util.List;

public class Publication  extends AcademicProduction {
	private String title;
	private String conferenceName;
	private Integer yearOfPublication;
	private Project associatedProject;
	
	private List<Collaborator> author = new ArrayList<>();
}
