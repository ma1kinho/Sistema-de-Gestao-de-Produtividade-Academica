package entities;

public abstract class AcademicProduction {
	private Integer year;
	private Project associatedProject;
	
	public AcademicProduction() {
	}
	
	public AcademicProduction(Integer year) {
		this.year = year;
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public abstract String toString();
}
