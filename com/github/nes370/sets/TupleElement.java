package com.github.nes370.sets;

public class TupleElement implements Element {

	private Element[] tuple;
	
	/**
	 * Creates a tuple element using the provided array of elements.
	 * 
	 * A tuple is a finite ordered list of elements.
	 * 
	 * @param element array
	 */
//	public TupleElement(Element[] tuple) {
//		this.tuple = tuple;
//	}
	
	/**
	 * Creates a tuple element using the provided array of elements.
	 * 
	 * A tuple is a finite ordered list of elements.
	 * 
	 * @param element array
	 */
	public TupleElement(Element... tuple) {
		this.tuple = tuple;
	}
	
	/**
	 * Creates a tuple element using the provided string array.
	 * 
	 * A tuple is a finite ordered list of elements.
	 * 
	 * @param string array
	 */
	public TupleElement(String... tuple) {
		this.tuple = new Element[tuple.length];
		for(int i = 0; i < tuple.length; i++)
			this.tuple[i] = new StringElement(tuple[i]);
	}
	
	/**
	 * @return the number of elements in the tuple element
	 */
	public int getLength() {
		return tuple.length;
	}
	
	/**
	 * Retrieves the element from the nth index.
	 * 
	 * @param n - tuple index
	 * @return the nth element of the tuple
	 */
	public Element getElement(int n) {
		return tuple[n];
	}
	
	@Override
	public boolean isEquivalentTo(Element e) {
		
		if(!this.getClass().isAssignableFrom(e.getClass()))
			return false;
		
		TupleElement te = (TupleElement) e;
		
		if(tuple.length != te.getLength())
			return false;
		
		for(int i = 0; i < tuple.length; i++)
			if(!tuple[i].isEquivalentTo(te.getElement(i)))
				return false;
		
		return true;
		
	}
	
	@Override
	public boolean isElementOf(SetElement S) {
		return S.contains(this);
	}

	
	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		
		s.append("(");
		
		if(tuple.length >= 1)
			s.append(tuple[0]);
		for(int i = 1; i < tuple.length; i++)
			s.append(", " + tuple[i]);
		
		s.append(")");
		
		return s.toString();
		
	}

}
