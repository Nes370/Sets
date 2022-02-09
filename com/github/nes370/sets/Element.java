package com.github.nes370.sets;

public interface Element {
	
	/**
	 * An element must be unique, and comparable to other elements.<p>
	 * Elements do not need to be ordered.
	 * 
	 * @param e - element to be tested for equivalence 
	 * @return {@code true} if this element is the same as element e
	 */
	public boolean isEquivalentTo(Element e);
	
	public boolean isElementOf(SetElement S);

}
