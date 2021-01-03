/*package Assignment2;

import java.util.ArrayList;

public class Course{
	private String code;
	private ArrayList <Assessment> assignment = new ArrayList<Assessment>();
	private double credit;

	public Course() {
	}

	public Course(Course o) {
		this.code = o.code;
		this.assignment = o.assignment;
		this.credit = o.credit;
	}
	
	public Course(String code, ArrayList<Assessment> assignment, double credit) {
		this.code = code;
		this.assignment = assignment;
		this.credit = credit;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public ArrayList<Assessment> getAssignment() {
		return assignment;
	}

	public void setAssignment(ArrayList<Assessment> assignment) {
		this.assignment = assignment;
	}
	
	@Override
	public boolean equals (Object o) {
	    if (!(o instanceof Course) || o == null) {
	    	return false; 
	    }
	    
	    Course c = (Course) o;
	    return credit == c.credit && code.equals(c.code);
	}
}*/
