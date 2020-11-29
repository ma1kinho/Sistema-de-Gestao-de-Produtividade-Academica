package entities;

public class Orientation extends AcademicProduction {
	private String description;
	private int qntTasks;
	private String [] tasks = new String[qntTasks];
	
	public Orientation() {
	}
	
	public Orientation(String description, Integer year, int qntTasks, String[] tasks) {
		super(year);
		this.description = description;
		this.qntTasks = qntTasks;
		this.tasks = tasks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQntTasks() {
		return qntTasks;
	}

	public void setQntTasks(int qntTasks) {
		this.qntTasks = qntTasks;
	}

	public String[] getTasks() {
		return tasks;
	}

	public void setTasks(String[] tasks) {
		this.tasks = tasks;
	}

	public String toString() {
		return null;
	}
}
