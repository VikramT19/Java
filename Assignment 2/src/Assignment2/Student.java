package Assignment2;

import java.util.ArrayList;
/*
class Student {

	private String studentID;
	private String name;
	private ArrayList<Course> courseTaken = new ArrayList<Course>();
	private ArrayList<Double> finalGrade = new ArrayList<Double>();
	
	public Student() {
	}

	public Student(String studentID, String name, ArrayList<Course> courseTaken) {
		this.studentID = studentID;
		this.name = name;
		this.courseTaken = courseTaken;
	}
	
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Course> getCourseTaken() {
		return courseTaken;
	}

	public void setCourseTaken(ArrayList<Course> courseTaken) {
		this.courseTaken = courseTaken;
	}

	public ArrayList<Double> getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(ArrayList<Double> finalGrade) {
		this.finalGrade = finalGrade;
	}

	
	public void addCourse(Course o) {
		courseTaken.add(o);
	}
	
	@Override
	public boolean equals (Object o) {
	    if (!(o instanceof Student) || o == null) {
	    	return false; 
	    }
	    
	    Student s = (Student) o;
	    return studentID.equals(s.studentID) && name.equals(s.name);
	}
	
	public void addGrade(ArrayList<Double> grade, ArrayList<Integer> weight) {
		double finalgrade = 0;
		
		for (int i = 0; i < grade.size(); i++) {
			double grades = grade.get(i);
			int weights = weight.get(i);
			finalgrade = finalgrade + ((grades/100.0)*weights);	
		}
		finalGrade.add(Math.round(finalgrade*10)/10.0);	
	}
	
	public double weightedGPA() {
		double average = 0;
		double gradePoint = 0;
		double credit = 0;
		for (int i = 0; i < finalGrade.size(); i++) {
			if (finalGrade.get(i) >= 90 && finalGrade.get(i) <= 100) {
				gradePoint = gradePoint + (9*courseTaken.get(i).getCredit());
				credit = credit + courseTaken.get(i).getCredit();
			}
			
			else if (finalGrade.get(i) >= 80 && finalGrade.get(i) <= 89.99) {
				gradePoint = gradePoint + (8*courseTaken.get(i).getCredit());
				credit = credit + courseTaken.get(i).getCredit();
			}
			
			else if (finalGrade.get(i) >= 75 && finalGrade.get(i) <= 79.99) {
				gradePoint = gradePoint + (7*courseTaken.get(i).getCredit());
				credit = credit + courseTaken.get(i).getCredit();
			}
			
			else if (finalGrade.get(i) >= 70 && finalGrade.get(i) <= 74.99) {
				gradePoint = gradePoint + (6*courseTaken.get(i).getCredit());
				credit = credit + courseTaken.get(i).getCredit();
			}
			
			else if (finalGrade.get(i) >= 65 && finalGrade.get(i) <= 69.99) {
				gradePoint = gradePoint + (5*courseTaken.get(i).getCredit());
				credit = credit + courseTaken.get(i).getCredit();
			}
			
			else if (finalGrade.get(i) >= 60 && finalGrade.get(i) <= 64.99) {
				gradePoint = gradePoint + (4*courseTaken.get(i).getCredit());
				credit = credit + courseTaken.get(i).getCredit();
			}
			
			else if (finalGrade.get(i) >= 55 && finalGrade.get(i) <= 59.99) {
				gradePoint = gradePoint + (3*courseTaken.get(i).getCredit());
				credit = credit + courseTaken.get(i).getCredit();
			}
			
			else if (finalGrade.get(i) >= 50 && finalGrade.get(i) <= 54.99) {
				gradePoint = gradePoint + (2*courseTaken.get(i).getCredit());
				credit = credit + courseTaken.get(i).getCredit();
			}
			
			else if (finalGrade.get(i) >= 47 && finalGrade.get(i) <= 49.99) {
				gradePoint = gradePoint + (1*courseTaken.get(i).getCredit());
				credit = credit + courseTaken.get(i).getCredit();
			}
			
			else if (finalGrade.get(i) > 47) {
				gradePoint = gradePoint + 0;
				credit = credit + courseTaken.get(i).getCredit();
			}

		}
		
		average = gradePoint/credit;
		
		return Math.round(average*10)/10.0;
	}
	
}*/