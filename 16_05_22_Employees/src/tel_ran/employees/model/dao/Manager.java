package tel_ran.employees.model.dao;

public class Manager extends Employee {

	int grade;

	public Manager(int id, String name, String postition, int basicSalary, int grade) {
		super(id, name, postition, basicSalary);
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return  "Manager " + super.toString()+" grade=" + grade;
	}
	public int computeSalary() {
		
		return super.computeSallary()*grade;
	}
	
}
