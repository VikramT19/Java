package Assignment2;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Vikram Thangavel
Student Number: 216933327
Course Section: Section E
*/


/**
* This class generates a transcript for each student, whose information is in the text file.
* 
*
*/

public class Transcript {
	private ArrayList<Object> grade = new ArrayList<Object>();
	private File inputFile;
	private String outputFile;
	
	/**
	 * This the the constructor for Transcript class that 
	 * initializes its instance variables and call readFie private
	 * method to read the file and construct this.grade.
	 * @param inFile is the name of the input file.
	 * @param outFile is the name of the output file.
	 */
	public Transcript(String inFile, String outFile) {
		inputFile = new File(inFile);	
		outputFile = outFile;	
		grade = new ArrayList<Object>(); 
		this.readFile();
	}// end of Transcript constructor

	/** 
	 * This method reads a text file and add each line as 
	 * an entry of grade ArrayList.
	 * @exception It throws FileNotFoundException if the file is not found.
	 * 
	 */
	private void readFile() {
		Scanner sc = null; 
		try {
			sc = new Scanner(inputFile);	
			while(sc.hasNextLine()){
				grade.add(sc.nextLine());
	        }      
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}		
	} // end of readFile

	/**@return ArrayList of students from the input file
	 *Creates an arraylist where all the students will be added to
	 *Loops through the whole file (grade arraylist as it holds each line from the file)
	 *3 For loops are created for the grades of assessments, weights of assessments, and storage of assessments
	 *An object is collected from the index of arraylist grade, then it's converted to a string and afterwards, an array of strings where the lines are deconstructed
	 *From the line, it collects data where is will be used to create a course (code and credit)
	 *Then, another loop is used to collect data about the assessments
	 *Afterwards, each assessments are created and all the other information about them are added into their rightfull arraylists
	 *Outside the loop of assessments, another loop is called to check if the student with the same name and student number exists. If so, it collects its index and adds the course and grades.
	 *If not, it creates a new student (student number and name) and adds all the courses he or she has taken and is added to their arraylists.
	 */
	public ArrayList<Student> buildStudentArray(){ // Builds arraylist of students
		ArrayList <Student> students = new ArrayList<Student>(); // Arraylist of students
		// Loop through the input file
		for (int i = 0; i < grade.size(); i++) { // File reading
			ArrayList <Double> grades = new ArrayList<Double>(); // Grades arraylist
			ArrayList <Integer> weights = new ArrayList<Integer>(); // Weights arraylist
			ArrayList <Assessment> assessments = new ArrayList<Assessment>(); // Assessments arraylist
			// Turns each line of input which is a object into an array of strings
			Object gradeObj = grade.get(i); // Gets object of line
			String gradeString = gradeObj.toString().trim(); // Line is turned into a string
			String[] stringPieces = gradeString.split(","); // String is broken down in pieces
			// New course is created
			Course c = new Course(); // New course 
			c.setCode(stringPieces[0]); // Code is set
			c.setCredit(Double.valueOf(stringPieces[1])); // Credit is set
			// Loop through the assessments and collects its data
			for (int j = 3; j < stringPieces.length-1; j++ ) {
				String cas = stringPieces[j]; // Assessment
				char type = cas.charAt(0); // Type of assessment
				char start = cas.charAt(1); // First character of string
				String weight = ""; // Empty string where weight data will be stored
				int num = 1; // Index variable used for iteration
				// Finding the weight
				while (start != '(' ) {  // Loop till weight data is collected
					weight = weight + String.valueOf(start); // Weight data
					start = cas.charAt(++num); // Incrementation
				} // End of whole loop
				String mark = ""; // Empty string where mark will be stored
				// Finding the mark
				while (cas.charAt(num) != ')') { // Loop until mark data is collected 
					++num; // Incrementation
					if (cas.charAt(num) != ')') { // If mark data is collected (Bracket is the last character we need)
						mark = mark + String.valueOf(cas.charAt(num)); // Mark data is collected
					} // End of if
				} // End of while loop
				Assessment a = Assessment.getInstance(type, Integer.valueOf(weight)); // Assessment is created
				assessments.add(a); // Assessment is added to arraylist
				c.setAssignment(assessments); // Assessment arraylist is set to course
				weights.add(Integer.valueOf(weight)); // Weight is added to arraylist
				grades.add(Double.valueOf(mark)); // Grades are added to arraylist
			} // End of for loop for assessments
			// Getting the courses and grades and adding it to students
			int index = 0; // Index variable
			boolean flag = true; // Flag variable
			// Checking if student exists in arraylist
			for (int k = 0; k < students.size(); k++) { // For loop
				if(students.get(k).getName().equals(stringPieces[stringPieces.length-1]) && students.get(k).getStudentID().equals(stringPieces[2])) { // If student exists with same student number and name
					index = k; // Index variable where student is stored is assigned
					flag = false; // Flag is initialied
				} // End of if statement
			} // End of for loop
			//If student exists or if student doesn't exist
 			if (flag == true) {// If student doesn't exist
				Student s = new Student(); // New student is created
				s.setName(stringPieces[stringPieces.length-1]); // Set name
				s.setStudentID(stringPieces[2]); // Set student number
				s.addGrade(grades, weights); // Student's grades are added
				s.addCourse(c);// Student's course is added
				students.add(s); // Student is added to arraylist
			} else { // If student already exists
				Student s = students.get(index); // Student is located
				s.addGrade(grades, weights); // Grades are added
				s.addCourse(c); // Course is added
			} // End of else statement 
		} // End of for loop of file reading
		return students; // Arraylist of students is returned
	} // End of buildarray method
	
	/**Method where transcript of students are printed
	 * Loops through arraylists and prints out their name, student number, courses taken, and grades.
	 * Finally, their gpa is printed/
	 * @param arraylist of students
	 */
	public void printTranscript(ArrayList<Student> students) { // Printing transcript
		try {
			FileWriter fw = new FileWriter(outputFile); // Output file where transcript is printed
			Writer output = new BufferedWriter(fw);
			// Loop of arraylist of students
			for (int i = 0; i < students.size(); i++) {				
				output.write(students.get(i).getName() + "\t" + students.get(i).getStudentID() + "\n"); // Output of name and student number
				output.write("--------------------" + "\n"); // Dashes
				for(int j = 0; j < students.get(i).getCourseTaken().size(); j++) { // Loop of courses taken
					output.write(students.get(i).getCourseTaken().get(j).getCode() + "\t" + students.get(i).getFinalGrade().get(j) + "\n"); // All the courses taken and grades
				}// End of for loop
				output.write("--------------------" + "\n");
				output.write("GPA: " + students.get(i).weightedGPA() + "\n"); // GPA
				output.write("\n");
			}
			output.close();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}			
	}
	// End of transcript class
	
	/**Class Student
	 */
	class Student {
		// Student's name, student number, courses taken, and final grades
		private String studentID;
		private String name;
		private ArrayList<Course> courseTaken = new ArrayList<Course>();
		private ArrayList<Double> finalGrade = new ArrayList<Double>();
		
		public Student() { // Default constructor
		}
		// Constructor for student object
		public Student(String studentID, String name, ArrayList<Course> courseTaken) {
			this.studentID = studentID;
			this.name = name;
			this.courseTaken = courseTaken;
		}
		// Getters and setters
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
		// Course is added to courseTaken arraylist
		public void addCourse(Course o) {
			courseTaken.add(o);
		}
		
		/** Method equals to check if objects are equal and are instance of class Student
		 */
		// Equals method checking if student is object of Student class
		@Override
		public boolean equals (Object o) {
		    if (!(o instanceof Student) || o == null) {
		    	return false; 
		    }
		    // Checking if student number and name are equal
		    Student s = (Student) o;
		    return studentID.equals(s.studentID) && name.equals(s.name);
		}
		// Adding final grade of course
		/**Final grade of class is calculated 
		 * Each grade of weight is added to calculate final grade of class
		 * Exceptions are also considered for total weight of assessments
		 * @param grade arraylist
		 * @param weight arraylist
		 */
		
		public void addGrade(ArrayList<Double> grade, ArrayList<Integer> weight){
			double finalgrade = 0; // Final grade
			int totalWeight = 0; // Total weight
			// Calculating final grade of course
			for (int i = 0; i < grade.size(); i++) { // Loop through grades
				double grades = grade.get(i); // Grades
				int weights = weight.get(i); // Weights
				totalWeight = totalWeight + weights; // Total weight
				finalgrade = finalgrade + ((grades/100.0)*weights); // Final grade
			} // End of loop
			//Exceptions
			if (totalWeight < 100) { // Less than 100
				throw new InvalidTotalException("Invalid sum of grades"); // Exception is thrown 
			}
			if (totalWeight > 100) { // More than 100
				throw new InvalidTotalException("Invalid sum of grades");// Exception is thrown 
			}
			finalGrade.add(Math.round(finalgrade*10)/10.0);	// Grade is added to arraylist
		} // End of add grade method
		
		// Exception class
		public class InvalidTotalException extends RuntimeException {
			private static final long serialVersionUID = 7913364474891953580L; // Exception UID
			public InvalidTotalException(String string) { // Exception constructor 
				super(string); // String message
			}
		}// End of exception class
		/**Calculating GPA of student
		 * @return GPA
		 */
		// GPA calculating method
		public double weightedGPA() {
			double average = 0; 
			double gradePoint = 0;
			double credit = 0;
			// Grade points
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
			average = gradePoint/credit; // GPA
			return Math.round(average*10)/10.0; // GPA is returned
		}
	}
} // End of Student class
/** Creating an assessment of a class
 */
// Assessment class
class Assessment {
	// Weight and type of assessments
	private int weight;
	private char type;

	private Assessment() { // Default constructor
	}
	// Assessment constructor
	private Assessment(char type, int weight) {
		this.type = type;
		this.weight = weight;
	}
	//Getters and setters
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
	// Creating an assessment
	public static Assessment getInstance(char type, int weight) {
		return new Assessment(type,weight);
	}
	// Equals methods checking if object is instance of assessment class 
	@Override
	public boolean equals (Object o) {
	    if (!(o instanceof Assessment) || o == null) {
	    	return false; 
	    }
	    Assessment a = (Assessment) o;
	    return weight == a.weight && type == a.type; // Checking if weight and type if equal
	}
}
// End of Assessment class

// Course class
/**Creating a class
 *
 */
class Course{
	// Code, credit, and assessments of a class
	private String code;
	private ArrayList <Assessment> assignment = new ArrayList<Assessment>();
	private double credit;

	public Course() { // Default constructor
	}
	// Course constructor
	public Course(Course o) {
		this.code = o.code;
		this.assignment = o.assignment;
		this.credit = o.credit;
	}
	// Course constructor
	public Course(String code, ArrayList<Assessment> assignment, double credit) {
		this.code = code;
		this.assignment = assignment;
		this.credit = credit;
	}
	// Getters and setters
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
	
	// Equals method for Course class
	@Override
	public boolean equals (Object o) {
	    if (!(o instanceof Course) || o == null) {
	    	return false; 
	    }
	    
	    Course c = (Course) o;
	    return credit == c.credit && code.equals(c.code); // Returns if credit and code are equal
	}
}
// End of Course class

