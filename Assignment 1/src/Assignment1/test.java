package Assignment1;

import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) {
		int startX = 5; 
		int startY = 5; 
		int n1 = 10;
		int n2 = 10;
		Map city = new Map (n1, n2);
		String actualPath = city.findPath (startX, startX);
	   System.out.print(actualPath);
	   
	 
	}

}
