package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.ProjectStatus;

public class Project {
	private String title;
	private Date startDate;
	private Date endDate;
	private String financeAgency;
	private Double financedAmount;
	private String objective;
	private String description;
	private List<Collaborator> participants = new ArrayList<>();
	private ProjectStatus status = ProjectStatus.IN_ELABORATION;
	private List<AcademicProduction> academicProduction = new ArrayList<>();
	
	public Project() {
	}

	public Project(String title, Date startDate, Date endDate, String financeAgency, 
			Double financedAmount, String objective, String description) {
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.financeAgency = financeAgency;
		this.financedAmount = financedAmount;
		this.objective = objective;
		this.description = description;
	}
	
	
	
}
