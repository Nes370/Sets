package com.github.nes370.sets;

public class StringElement implements Element, Comparable<StringElement> {

	private String string;
	
	public StringElement(String string) {
		this.string = string;
	}
	
	public String getString() {
		return string;
	}
	
	@Override
	public boolean isEquivalent(Element e) {
		
		if(!this.getClass().isAssignableFrom(e.getClass()))
			return false;
		
		return (this.string).equals(((StringElement) e).getString());
		
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
