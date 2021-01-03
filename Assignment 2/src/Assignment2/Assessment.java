/*package Assignment2;

public class Assessment {
	private int weight;
	private char type;

	private Assessment() {
	}
	
	private Assessment(char type, int weight) {
		this.type = type;
		this.weight = weight;
	}
	
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

	public static Assessment getInstance(char type, int weight) {
		return new Assessment(type,weight);
	}
	
	@Override
	public boolean equals (Object o) {
	    if (!(o instanceof Assessment) || o == null) {
	    	return false; 
	    }
	    Assessment a = (Assessment) o;
	    return weight == a.weight && type == a.type;
	}
}
*/