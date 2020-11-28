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
	private List<AcademicProduction> academicProductions = new ArrayList<>();
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFinanceAgency() {
		return financeAgency;
	}

	public void setFinanceAgency(String financeAgency) {
		this.financeAgency = financeAgency;
	}

	public Double getFinancedAmount() {
		return financedAmount;
	}

	public void setFinancedAmount(Double financedAmount) {
		this.financedAmount = financedAmount;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Collaborator> getParticipants() {
		return participants;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public List<AcademicProduction> getAcademicProduction() {
		return academicProductions;
	}
	
	public void addParticipant(Collaborator participant) {
		participants.add(participant);
	}
	
	public void addAcademicProduction(AcademicProduction academicProduction) {
		academicProductions.add(academicProduction);
	}
}
