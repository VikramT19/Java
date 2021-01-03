package myUtil_Set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MyHashSet<E> extends MyAbstractSet<E> {

	
	private HashMap <E, Object> map;   
	
	/** Dummy value to associate with an Object in the backing Map
	    used as vlaues for all the keys in the backing Map
	*/
    private static final Object PRESENT = new Object();
	
	
    /**
     * Constructs a new, empty set; 
     */
    public MyHashSet() {
        map = new HashMap<>();
    }
    
    /**
	 * Create an empty set of default capacity
	 * 
	 */
    public MyHashSet(int initialCapacity) {
    	super();
    	this.map = new HashMap<>(initialCapacity);    }
    
     
	@Override
    public Iterator<E> iterator(){
    	return this.map.keySet().iterator();
    }
	
	@Override
	public int size() {
		return this.map.size();
	}
	
	@Override
	public boolean isEmpty() {
		return this.map.size()==0;
	}
	
	@Override
	public boolean contains(E o) { 
		for (int i = 0; i < this.map.size(); i++) {
			if(this.map.containsKey(o)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	// Hint. add e into map as key, with the Dummy object PRESENT as value.
	// Hint. look Map API for the return type of put
	public boolean add(E e) {
		if (map.containsKey(e)) {
			return false;
		}
		map.put(e, PRESENT);
		return true;
	}
	
	@Override
	public boolean remove(E o) {
		if (map.containsKey(o)) {
			map.remove(o);
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		map.clear();
	}
	
	//Other methods, such as the following size(), isEmpty(), addAll(),   
	//are inherited from MyAbstractSet
     
	    
	 


}
