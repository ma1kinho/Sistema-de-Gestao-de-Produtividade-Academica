package entities;

public abstract class AcademicProduction implements Comparable<AcademicProduction> {

	protected Integer year;
	protected Project associatedProject;
	
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
	
	public Project getAssociatedProject() {
		return associatedProject;
	}

	public void projectAssociation(Project project) {
		associatedProject = project;
	}

	@Override
	public int compareTo(AcademicProduction academicProduction) {
		if(this.year > academicProduction.getYear()) {
			return -1;
		} else if(this.year < academicProduction.getYear()) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public abstract String toString();
	//public abstract void printAcademicProduction();
}
