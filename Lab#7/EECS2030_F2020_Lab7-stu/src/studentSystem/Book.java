package studentSystem;

import java.util.Objects;

public class Book implements Comparable<Book>{
		
		
		/**
		 * The yearPublished field is an int 
		 * that holds the book's year when it is published 
		 */
		private int yearPublished;
		
		/**
		 * The title field 
		 * references a String object that holds the title of the book
		 */
		private String title;
		
		
		/**
		 * The course that this book for, e.g., "EECS2030" 
		 * 
		*/
		private  String courseCode; 
		
		
		private int edition;
		
	
		/**
		 * custom constructor 
		 * Initializes this book to have specific values for 
		 * its fields
		 *  
		 * @param title  the book title 
		 * @param yearPublished the year of book title
		 * @param price  price of this book 
		 * 
		 */
		public Book(String title, int ed, int yearPublished, String courseID) {
			
			this.yearPublished=yearPublished;
			this.title=title;
			this.edition = ed;
			this.courseCode = courseID;
			
		}

		
			
		/**
		 * Returns the year  (yearPublished) field value 
		 * @return the year published field value of this book
		 */
		public int getyearPublished()
	    {
	        return this.yearPublished;
	    }
		
		
	    /**
	     *  Returns the  title (title) field value 
		 * @return the title field value of this book
	     */
	    public String gettitle ()
	    {
	        return this.title;
	    }
	    
		
		/**
		 * Returns the price value of this book .
		 * 
		 * @return the  price value of this book
		 */
		public String getCourseCode() {
			return this.courseCode;
		}
		
		@Override	
		public int compareTo(Book o) {
			if (yearPublished < o.getyearPublished()) {
                	return -1;
            }
			
			else if (yearPublished > o.getyearPublished()) {
                	return 1;
            }
                
			else if (yearPublished == o.getyearPublished()) {
				return courseCode.compareTo(o.courseCode);
            }
			return 0;
        }
		
		public boolean equals(Object o) {
			if (!(o instanceof Book) || o == null) {
		    	return false; 
		    }
            
			Book b = (Book) o;
			return this.yearPublished == b.yearPublished && this.title.equals(b.title) && this.courseCode.equals(b.courseCode) && this.edition == b.edition;
		}
		
	    @Override
	    public String toString() {
	    	return "(" + title + ", ed:" + edition + ", " + yearPublished + ", course:" + courseCode + ")";
	    }
	    
	    @Override
	    public int hashCode() {
	    	return Objects.hash(yearPublished, courseCode);
	    }
		 
		/**
		 * This class defines logic equality of Book objects, as follows:
		 * two books are considered equal to each other if they have the same year, same title, 
		 * same course code and same edition. 
		 */
		 
		

		/**
		 * This class defines the natural ordering of Book objects, as follows:
		 * When 'this' book is compared with the specified book, 
		 * 'this' book is "less than" the specified book if its publishing year is earlier than that of the specified book.
		 * and is "greater than" the specified book if the publishing year is after that of the specified book.
		 *
		 * If the years are the same, then they are further compared based on lexicographical ordering of courseCode.
		 * 'this' book is "less than" the specified book if its courseCode lexicographically precedes that of the specified book,
		 * and is "greater than" the specified book if its courseCode lexicographically follows that of the specified book.
		 * E.g., "EECS1710" lexicographically precedes "EECS1720", which in turn precedes "EECS2030"
		 * 
		 * The result is 0 if the courseCodes are (also) equal.
		 */
		
		
		 
	}

		

