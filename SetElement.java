package com.github.nes370.sets;

import java.util.HashSet;
import java.util.Iterator;

public class SetElement implements Element {

	private HashSet<Element> set;
	
	public SetElement() {
		set = new HashSet<Element>();
	}
	
	private HashSet<Element> getSet() {
		return set;
	}
	
	public int getSize() {
		return set.size();
	}
	
	public boolean contains(Element e) {
		
		for(Element f : set)
			if(f.isEquivalent(e))
				return true;
		
		return false;
		
	}
	
	public boolean contains(String e) {
		return contains(new StringElement(e));
	}
	
	public boolean add(Element e) {
		
		if(!this.contains(e)) {
			return set.add(e);
		}
		
		return false;
		
	}
	
	public boolean add(String e) {
		return this.add(new StringElement(e));
	}
	
	public boolean addAll(SetElement S) {
		
		boolean anyAdded = false;
		
		for(Element e : S.getSet()) {
			anyAdded = anyAdded || this.add(e);
		}
		
		return anyAdded;
		
	}
	
	public boolean remove(Element e) {
		
		for(Element f : set)
			if(f.isEquivalent(e))
				return set.remove(f);
		
		return false;
		
	}
	
	public boolean remove(String e) {
		return this.remove(new StringElement(e));
	}
	
	public boolean removeAll(SetElement S) {
		
		boolean anyRemoved = false;
		
		for(Element e : S.getSet()) {
			anyRemoved = anyRemoved || this.remove(e);
		}
		
		return anyRemoved;
		
	}
	
	public SetElement generateSubsets() {
		
		SetElement subsets = new SetElement();
		
		for(int i = 0; i < Math.pow(2, set.size()); i++) {
			
			SetElement subset = new SetElement();
			Iterator<Element> iterator = set.iterator();
			
			for(int j = 0; iterator.hasNext(); j++) {
				Element e = iterator.next();
				if((i >> j) % 2 == 1) {
					subset.add(e);
				}
			}

			subsets.add(subset);
		}
		
		return subsets;
		
	}
	
	public SetElement intersection(SetElement B) {
		
		SetElement intersection = new SetElement();
		
		for(Element e : set)
			if(B.contains(e))
				intersection.add(e);
		
		return intersection;
		
	}
	
	public SetElement union(SetElement B) {
		
		SetElement union = new SetElement();
		
		union.addAll(this);
		union.addAll(B);
		
		return union;
		
	}
	
	public SetElement difference(SetElement B) {
		
		SetElement difference = new SetElement();
		
		for(Element e : set)
			if(!B.contains(e))
				difference.add(e);
		
		return difference;
		
	}
	
	public SetElement product(SetElement B) {
		
		SetElement product = new SetElement();
		
		for(Element x : set)
			for(Element y : B.getSet())
				product.add("(" + x + ", " + y + ")");
		
		return product;
		
	}
	
	public boolean isSubset(SetElement B) {
		
		if(this.getSize() > B.getSize())
			return false;
		
		for(Element e : set)
			if(!B.contains(e))
				return false;
		
		return true;
		
	}
	
	public boolean isProperSubset(SetElement B) {
		
		if(this.getSize() >= B.getSize() || !this.isSubset(B))
			return false;
		
		for(Element e : B.getSet())
			if(!this.contains(e))
				return true;
		
		return false;
		
	}
	
	@Override
	public boolean isEquivalent(Element e) {
		
		if(!this.getClass().isAssignableFrom(e.getClass())) {
			return false;
		}
		
		SetElement se = (SetElement) e;
		
		if(!(set.size() == se.getSize())) {
			return false;
		}
			
		for(Element x : set) {
			boolean exists = false;
			for(Element y : se.getSet()) {
				if(x.isEquivalent(y)) {
					exists = true;
				}
				if(exists)
					break;
			}
			if(!exists) {
				return false;
			}
		}
		
		return true;
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		
		Iterator<Element> iterator = set.iterator();
		
		s.append("{");
		
		if(iterator.hasNext())
			s.append(iterator.next());
		while(iterator.hasNext())
			s.append(", " + iterator.next());
		
		s.append("}");
		
		return s.toString();
		
	}

}
