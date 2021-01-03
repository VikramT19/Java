package myUtil_List;

public class MyArrayList<E> implements MyList<E> {

	private static final int DEFAULT_CAPACITY = 10;
	
	int size;  // non-private for testing purpose
	E [] elementData; // non-private for testing purpose
	
	/**
	 * Create an empty list of capacity capa
	 * 
	 * @param capa the initial capacity. Assume greater than 0.
	 */
	@SuppressWarnings({"unchecked"})
    public MyArrayList(int capa) {
		this.elementData = (E[])new Object [capa]; // generic for Array, have to do this
	}

	/**
	 * Create an empty list of default capacity
	 * 
	 */
    @SuppressWarnings({"unchecked"})
    public MyArrayList() {
		this.elementData = (E[])new Object [DEFAULT_CAPACITY];
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) { 
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(E o) {
		if(this.elementData.length == this.size) {
			E[] e = (E[]) new Object[this.elementData.length + DEFAULT_CAPACITY];
			for(int i = 0; i < elementData.length; i++) {
				e[i] = elementData[i];
			}
			this.elementData = e;
		}
		this.elementData[size] = o;
		size++;
	}

	@Override
	public void remove(E o) {
		for(int i = 0; i < this.size-1; i++) {
			if (this.elementData[i].equals(o)) {
				for (int j = i; j < this.size; j++) {
					this.elementData[j] = this.elementData[j+1];
				}
				size--;
			}
		}
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return (E) this.elementData[index]; 
	}

	@Override
	public E set(int index, E element) {
		if( index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
		}
        E e = elementData[ index ];    
        elementData[ index ] = element;
        return e;    
	}

	@Override
	public void add(int index, E element) {
		if (index < 0 || index >= this.size || this.size == 0) {
			throw new IndexOutOfBoundsException();
		}
		for (int i=this.size-1; i>=index; i--) {
			elementData[i+1] = elementData[i];
		}
		this.elementData[index] = element;
		this.size++;
	}

	@Override
	public E remove(int index) {
		get(index);
		E e = elementData[index];
	    for (int j = index; j < size - 1; j++) {
	    	elementData[j] = elementData[j + 1];
	    }
	    elementData[size - 1] = null;
	    size--;
	    return e;
	}

	@Override
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) { 
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E o) {
		 for (int i = size - 1; i >= 0; i--) {
			 if (o.equals(elementData[i])) return i;
		 }
		 return -1;
	}
}
