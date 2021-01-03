package studentSystem;

import java.util.Comparator;

public class ProfByNameComparator implements Comparator<Prof> {

	public ProfByNameComparator() {
	}
	
	public int compare(Prof a, Prof b) {
		return a.getName().compareTo(b.getName());
	}
}
