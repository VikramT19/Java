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

package Assignment1;

import java.util.*;

/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean[][] map;
	private int row;
	private int column;

	/**
	 * This is the constructor that constructs the city map, which is a grid of row
	 * by column.
	 * 
	 * @param row    is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) { // Constructor
		this.row = row; // Number of rows
		this.column = column; // Number of columns
	}

	/**
	 * This method checks the correctness of the input parameters. If the
	 * preconditions are not met an exception is thrown, otherwise depending to the
	 * direction, it calls one of the four recursive functions of goSouthWest,
	 * goSouthEast, goNorthWest and goNorthEast.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0,
	 *      N) if N is the number of east-west streets and [0, M) if M is the number
	 *      of north-south streets.)
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath(int startRow, int startCol, int destRow, int destCol, String path) { // Constructor
		
		// Checking if the input is within the number of rows and number of columns given
		
		// If each input given has a number of rows and a number of columns that is within the map size, then it does nothing
		if (((startRow >= 0 && startRow <= row) && (startCol >= 0 && startCol <= column) && (destRow >= 0 && destRow <= row) && (destCol >= 0 && destCol <= column))) {
		} // Nothing happens
		
		// If it exceeds the map's sizes, it will throw a argument stating that the input is invalid
		else {
			throw new IllegalArgumentException("Input is not valid"); // Exception argument is thrown
		}
		
		// If the initial row and initial column is bigger than the destination row and destination column, it has to go south west and it will call the method
		if (startRow >= destRow && startCol >= destCol) { // Conditions
			return goSouthWest(startRow, startCol, destRow, destCol, path); // Method is called
		}

		// If the initial row is bigger than the destination row and the initial column is smaller than the destination column, it has to go south east and it will call the method
		if (startRow >= destRow && startCol <= destCol) { // Conditions
			return goSouthEast(startRow, startCol, destRow, destCol, path); // Method is called
		}

		// If the initial row and initial column is smaller than the destination row and destination column, it has to go north east and it will call the method
		if (startRow <= destRow && startCol <= destCol) { // Conditions
			return goNorthEast(startRow, startCol, destRow, destCol, path); // Method is called
		}
		
		// If the initial row is smaller than the destination row and the initial column is bigger than the destination column, it has to go north west and it will call the method
		if (startRow <= destRow && startCol >= destCol) { // Conditions
			return goNorthWest(startRow, startCol, destRow, destCol, path); // Method is called
		}

		return path; // Return the path

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol >= destCol </code>
	 */

	// Method to go south west
	private String goSouthWest(int startRow, int startCol, int destRow, int destCol, String path) { // Constructor

		// Base case; if the initial row and initial column equals the destination row and destination column, the recursion ends and returns the path
		if (startRow == destRow && startCol == destCol) { // Conditions
			return path; // Returns path
		}

		// Recursive cases
		if (startRow != destRow) { // If the initial row still doesn't equal the destination row, recursion continues
			path = path + "(" + (startRow - 1) + "," + startCol + ") "; // Adds point to path
			return goSouthWest(startRow - 1, startCol, destRow, destCol, path); // Recursion call; since it has to go south, the number of rows has to decrease
		}

		if (startCol != destCol) { // If the initial column still doesn't equal the destination column, recursion continues
			path = path + "(" + startRow + "," + (startCol - 1) + ") "; // Adds point to path
			return goSouthWest(startRow, startCol - 1, destRow, destCol, path); // Since it has to go west from the initial point, the number of columns has to decrease
		}

		return path; // Returns path 

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol <= destCol </code>
	 */
	
	// Method to go south east
	private String goSouthEast(int startRow, int startCol, int destRow, int destCol, String path) { // Constructor

		// Base case; if the initial row and initial column equals the destination row and destination column, the recursion ends and returns the path
		if (startRow == destRow && startCol == destCol) { // Conditions
			return path; // Returns path
		}

		// Recursive cases
		if (startRow != destRow) { // If the initial row still doesn't equal the destination row, recursion continues
			path = path + "(" + (startRow - 1) + "," + startCol + ") "; // Adds point to path
			return goSouthEast(startRow - 1, startCol, destRow, destCol, path); // Since we have to go south, the number of rows has to decrease
		}

		if (startCol != destCol) { // If the initial column still doesn't equal the destination column, recursion continues
			path = path + "(" + startRow + "," + (startCol + 1) + ") "; // Adds points to path
			return goSouthEast(startRow, startCol + 1, destRow, destCol, path); // Since we have to go east, the number of columns has to increase
		}

		return path; // Returns path

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and
	 *      <code> startCol >= destCol </code>
	 */
	
	// Method to go north east
	private String goNorthEast(int startRow, int startCol, int destRow, int destCol, String path) { // Constructor

		// Base case; if the initial row and initial column equals the destination row and destination column, the recursion ends and returns the path
		if (startRow == destRow && startCol == destCol) { // Conditions
			return path; // Returns path
		}

		// Recursive cases
		if (startRow != destRow) { // If the initial row still doesn't equal the destination row, recursion continues
			path = path + "(" + (startRow + 1) + "," + startCol + ") "; // Adds point to path
			return goNorthEast(startRow + 1, startCol, destRow, destCol, path); // Since we have to go north, the number of rows has to increase
		}

		if (startCol != destCol) { // If the initial column still doesn't equal the destination column, recursion continues
			path = path + "(" + startRow + "," + (startCol + 1) + ") "; // Adds point to path
			return goNorthEast(startRow, startCol + 1, destRow, destCol, path); // Since we have to go east, the number of columns has to increase
		}

		return path; // Returns path

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol <= destCol </code>
	 */
	
	// Method to go north west
	private String goNorthWest(int startRow, int startCol, int destRow, int destCol, String path) { // Constructor

		// Base case; if the initial row and initial column equals the destination row and destination column, the recursion ends and returns the path
		if (startRow == destRow && startCol == destCol) { // Conditions
			return path; // Returns path
		}

		// Recursive cases
		if (startRow != destRow) { // If the initial row still doesn't equal the destination row, recursion continues
			path = path + "(" + (startRow + 1) + "," + startCol + ") "; // Adds point to path
			return goNorthWest(startRow + 1, startCol, destRow, destCol, path); // Since we have to go north, the number of rows has to increase
		}

		if (startCol != destCol) { // If the initial column still doesn't equal the destination column, recursion continues 
			path = path + "(" + startRow + "," + (startCol - 1) + ") "; // Adds point to path
			return goNorthWest(startRow, startCol - 1, destRow, destCol, path); // Since we have to go west, the number of columns has to decrease
		}

		return path; // Returns path 

	}

	/**
	 * This method find a path from (startRow, startCol) to a border point of the
	 * city. Please note that the starting point should be included in the path.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the
	 *         city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */

	// Method that is called by the other method; This method has more arguments since we can keep value of variable during the recursion
	public String findPath(int startRow, int startCol, String path, int initialRow, int initialCol) { // Construct
	// number of rows (recursed); number of columns (recursed); path (points will be added); initial value of rows; initial of columns

		// Base case; if the grid of the map is located, recursion ends and path is returned
		if ((startRow == row || startRow == 0) || (startCol == column || startCol == 0)) { // Conditions
			return path; // Path is returned
		}
		
		// Recursion calls

		else {

			int r = (int) (Math.random() * 4 + 1); // Random number generator from 1 to 4
			
			// If the random number is 1
			if (r == 1) { // Random number is 1
				String point = "(" + (startRow + 1) + "," + startCol + ") "; // New point is created; car goes north
				
				// If the path contains the point (Duplicate)
				if (path.contains(point)) { // Checks if there is a duplicate
					startRow = initialRow; // Number of rows is set to the initial number of rows
					startCol = initialCol; // Number of columns is set to the initial number of columns
					path = "(" + startRow + "," + startCol + ") "; // Path is set to empty except with the initial point
					return findPath(startRow, startCol, path, initialRow, initialCol); // Method restarts (Recursion)
				}

				// If the path doesn't contain the point (No duplicate)
				else {
					path = path + point; // Point is added to path
					 return findPath(startRow + 1, startCol, path, initialRow, initialCol); // Recursion continues with new number of rows
				}
			}

			// If the random number is 2
			if (r == 2) { //  Random number is 2
				String point = "(" + startRow + "," + (startCol + 1) + ") "; // New point is created; car goes east

				// If the path contains the point (Duplicate) 
				if (path.contains(point)) { // Checks if there is a duplicate
					startRow = initialRow; //  Number of rows is set to the initial number of rows
					startCol = initialCol; // Number of columns is set to the initial number of columns
					path = "(" + startRow + "," + startCol + ") "; // Path is set to empty except with the initial point
					return findPath(startRow, startCol, path, initialRow, initialCol); // Method restarts (Recursion)
				}

				// If the path doesn't contain the point (No duplicate)
				else {
					path = path + point; // Point is added to path 
					 return findPath(startRow, startCol + 1, path, initialRow, initialCol); // Recursion continues with new number of columns
				}
			}

			// If the random number is 3 
			if (r == 3) { // Random number is 3
				String point = "(" + (startRow - 1) + "," + startCol + ") "; // New point is created; car goes south

				// If the path contains the point (Duplicate)
				if (path.contains(point)) { // Checks if there is a duplicate
					startRow = initialRow; // Number of rows is set to the initial number of rows
					startCol = initialCol; //  Number of columns is set to the initial number of columns
					path = "(" + startRow + "," + startCol + ") "; // Path is set to empty set except with the initial point
					return findPath(startRow, startCol, path, initialRow, initialCol); // Method restarts (Recursion)
				}

				// If the path doesn't contain the point (No duplicate)
				else {
					path = path + point; // Point is added to path
					return findPath(startRow - 1, startCol, path, initialRow, initialCol); // Recursion continues with new number of rows
				}
			}

			// If the random number is 4
			if (r == 4) { // Random number is 4
				String point = "(" + startRow + "," + (startCol-1) + ") "; // New point is created; car goes west
				
				if (path.contains(point)) { // Checks if there is a duplicate
					startRow = initialRow; // Number of rows is set to the initial number of rows
					startCol = initialCol; // Number of columns is set to the initial number of columns
					path = "(" + startRow + "," + startCol + ") "; // Path is set to empty set except with the initial point
					return findPath(startRow, startCol, path, initialRow,initialCol); // Method restarts (Recursion)
				}

				// If the path doesn't contain the point (No duplicate)
				else {
					path = path + point; // point is added to path
					return findPath(startRow, startCol - 1, path, initialRow, initialCol); // Recursion continues with new number of columns
				}

			}

		}

		return path; // Returns path

	}

	// Method to find path
	public String findPath(int startRow, int startCol) { // Constructor
		return findPath(startRow, startCol, "(" + startRow + "," + startCol + ") ", startRow, startCol); // Calls the method above with more arguments in constructor (Another method I created)
	}

} // end of class
