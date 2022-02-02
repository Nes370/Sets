package com.github.nes370.sets;

public class TupleElement implements Element {

	private Element[] tuple;
	
	public TupleElement(Element[] tuple) {
		this.tuple = tuple;
	}
	
	public int getLength() {
		return tuple.length;
	}
	
	public Element getElement(int n) {
		return tuple[n];
	}
	
	@Override
	public boolean isEquivalent(Element e) {
		
		if(!this.getClass().isAssignableFrom(e.getClass()))
			return false;
		
		TupleElement te = (TupleElement) e;
		
		if(tuple.length != te.getLength())
			return false;
		
		for(int i = 0; i < tuple.length; i++)
			if(!tuple[i].isEquivalent(te.getElement(i)))
				return false;
		
		return true;
		
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
