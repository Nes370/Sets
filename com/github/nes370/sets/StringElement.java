package com.github.nes370.sets;

public class StringElement implements Element, Comparable<StringElement> {

	private String string;
	
	/**
	 * Creates a string element from the provided string.<p>
	 * 
	 * A string is a sequence of characters.
	 * 
	 * @param string
	 */
	public StringElement(String string) {
		this.string = string;
	}
	
	/**
	 * @return the value of the stored string
	 */
	public String getString() {
		return string;
	}
	
	@Override
	public boolean isEquivalentTo(Element e) {
		
		if(!this.getClass().isAssignableFrom(e.getClass()))
			return false;
		
		return (this.string).equals(((StringElement) e).getString());
		
	}
	
	@Override
	public boolean isElementOf(SetElement S) {
		return S.contains(this);
	}

	@Override
	public int compareTo(StringElement e) {
		return this.getString().compareTo(e.getString());
	}

	@Override
	public String toString() {
		return string;
	}
	
}
