package com.github.nes370.sets;

interface Element {
	
	// An element must be unique, and comparable to other elements
	public boolean isEquivalent(Element e);
	
	// Elements do not need to be ordered

}
