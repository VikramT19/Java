package Assignment2;

import java.util.ArrayList;

import Assignment2.Transcript.Student;

public class testCode {

	public static void main(String[] args) {
		Transcript ts = new Transcript("input.txt", "output.txt");
		ArrayList<Student> arr = ts.buildStudentArray();
		ts.printTranscript(arr);
	}

}
