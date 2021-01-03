package studentSystem;

import java.util.Objects;

public class Prof implements Comparable<Prof> {
	private String name;
	private String id;
	private int year;  // year of employment
	
	public Prof(String name, String id, int year) {
		this.name = name;
		this.id = id;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
    public int compareTo(Prof o) {
		if(year < o.getYear()) {
			return -1;
        }
        
        else if (year > o.getYear()) {
        	return 1;
        }
        
        else if(year == o.getYear()) {
        	if(id.compareTo(o.getId()) < 0) {
        		return -1;
        	}
        
        	else if (id.compareTo(o.getId()) > 0) {
        		return 1;
        	}
        	
        	else if (id.compareTo(o.getId()) == 0) {
        		return 0;
        	}
        }
        
        return 0;
    }

	public boolean equals (Object o) {
	    if (!(o instanceof Prof) || o == null) {
	    	return false; 
	    }
	    
	    Prof p = (Prof) o;
	    return year == p.year && id.equals(p.id);
	}
	
	@Override
	public String toString() {
		return "[name:" + name + ", id:" + id + ", year:" + year +"]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(year, id);
	}
		
	/** this class defines the logic equality of Prof objects, as follows:
	/ two profs are considered equal to each other if they have the same id and same year of employment.
	**/
	
	 

	/**This class defined the natural ordering of Prof objects, as follows:
	 * When 'this' Prof is compared with the specified Prof, 
	 * 'this' Prof is "less than" the specified Prof if his year of employment is less than 
	 * that of the specified Prof, and is "greater than" the specified Prof if his year of employment is greater than that of 
	 * the specified Prof.
	 * If the years are the same, then they are further compared based on their ids.
	 * 'this' Prof is "less than" the specified Prof if his id lexicographically precedes that of the specified Prof.
	 * and is "greater than" the specified Prof if his id lexicographically follows that of the specified Prof.
	 * E.g., "yu1719" lexicographically precedes "yu1765", which precedes "yu4203".
	 * 
	 * The comparison result is zero if the ids are (also) equal.
	 * 
	 * 
	 **/

	 
			
}
