package com.github.nes370.sets;

import java.util.HashSet;
import java.util.Iterator;

public class SetElement implements Element {

	private HashSet<Element> set;
	
	/**
	 * Creates a new empty set element.
	 */
	public SetElement() {
		set = new HashSet<Element>();
	}
	
	private HashSet<Element> getSet() {
		return set;
	}
	
	/**
	 * @return the number of elements in the set
	 */
	public int getSize() {
		return set.size();
	}
	
	/**
	 * @param e - element whose presence in this set is to be tested
	 * @return {@code true} if this set contains element e
	 */
	public boolean contains(Element e) {
		
		for(Element f : set)
			if(f.isEquivalentTo(e))
				return true;
		
		return false;
		
	}
	
	/**
	 * @param e - string whose presence in this set is to be tested
	 * @return {@code true} if this set contains an element equivalent to string e
	 */
	public boolean contains(String e) {
		return contains(new StringElement(e));
	}
	
	/**
	 * @param S - a set of elements
	 * @return {@code true} if this set contains all elements in set S
	 */
	public boolean containsAll(SetElement S) {
		
		for(Element e : S.getSet())
			if(!this.contains(e))
				return false;
		
		return true;
		
	}
	
	/**
	 * @param e - element to be added to this set
	 * @return {@code true} if this set did not already contain element e
	 */
	public boolean add(Element e) {
		
		if(!this.contains(e)) {
			return set.add(e);
		}
		
		return false;
		
	}
	
	/**
	 * @param e - string to be added to this set as an element
	 * @return {@code true} if this set did not already contain an element equivalent to string e
	 */
	public boolean add(String e) {
		return this.add(new StringElement(e));
	}
	
	/**
	 * @param e - string array to be added to this set as a tuple element
	 * @return {@code true} if this set did not already contain an element equivalent to string array e
	 */
	public boolean add(String[] e) {
		return this.add(new TupleElement(e));
	}
	
	/**
	 * @param S - a set of elements to be added to this set
	 * @return {@code true} if this set added any element of set S
	 */
	public boolean addAll(SetElement S) {
		
		boolean anyAdded = false;
		
		for(Element e : S.getSet()) {
			anyAdded = this.add(e) || anyAdded;
		}
		
		return anyAdded;
		
	}
	
	public boolean addAll(String... S) {
		
		boolean anyAdded = false;
		
		for(String e : S) {
			anyAdded = this.add(new StringElement(e)) || anyAdded;
		}
		
		return anyAdded;
	}
	
	/**
	 * @param e - element to be removed from this set
	 * @return {@code true} if this set contained element e 
	 */
	public boolean remove(Element e) {
		
		for(Element f : set)
			if(f.isEquivalentTo(e))
				return set.remove(f);
		
		return false;
		
	}
	
	/**
	 * @param e - string to be removed from this set as an element
	 * @return {@code true} if this set contained an element equivalent to string e 
	 */
	public boolean remove(String e) {
		return this.remove(new StringElement(e));
	}
	
	/**
	 * @param S - a set of elements to be removed from this set
	 * @return {@code true} if this set removed any element of set S
	 */
	public boolean removeAll(SetElement S) {
		
		boolean anyRemoved = false;
		
		for(Element e : S.getSet()) {
			anyRemoved = this.remove(e) || anyRemoved;
		}
		
		return anyRemoved;
		
	}
	
	/**
	 * Generates a new set containing every subset of this set.
	 * 
	 * @return set of all subsets
	 */
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
	
	/**
	 * An element is in the intersection of two sets if and only if the element is found in both sets.<p>
	 * A ∩ B = { e | (e ∈ A) ∧ (e ∈ B) }
	 * 
	 * @param B - a set of elements
	 * @return a set representing the intersection between this set and set B
	 */
	public SetElement intersection(SetElement B) {
		
		SetElement intersection = new SetElement();
		
		for(Element e : set)
			if(B.contains(e))
				intersection.add(e);
		
		return intersection;
		
	}
	
	/**
	 * An element is in the union of two sets if it is in at least one of the two sets.<p>
	 * A ∪ B = { e | (e ∈ A) ∨ (e ∈ B) }
	 * 
	 * @param B - a set of elements
	 * @return a set representing the union between this set and set B
	 */
	public SetElement union(SetElement B) {
		
		SetElement union = new SetElement();
		
		union.addAll(this);
		union.addAll(B);
		
		return union;
		
	}
	
	/**
	 * An element is in the difference of two sets if it is in the first set and not in the second.<p>
	 * A - B = { e | (e ∈ A) ∧ ¬(e ∈ B) }
	 * 
	 * @param B - a set of elements
	 * @return a set representing the difference of set B from this set
	 */
	public SetElement difference(SetElement B) {
		
		SetElement difference = new SetElement();
		
		for(Element e : set)
			if(!B.contains(e))
				difference.add(e);
		
		return difference;
		
	}
	
	/**
	 * Each element of a Cartesian product is a 2-tuple.
	 * The first item of each tuple must be an element of set A, and the second item of each tuple must be an element of Set B.<p>
	 * A ⨯ B = { (x, y) | (x ∈ A) ∧ (y ∈ B) }
	 * 
	 * @param B - a set of elements
	 * @return the Cartesian product between this set and set B
	 */
	public SetElement product(SetElement B) {
		
		SetElement product = new SetElement();
		
		for(Element x : set)
			for(Element y : B.getSet())
				product.add("(" + x + ", " + y + ")");
		
		return product;
		
	}
	
	/**
	 * A is a subset of B if and only if there are no elements that are in A and not in B.<p>
	 * A ⊆ B ⇔ (A - B) = {}
	 * 
	 * @param B - a set of elements
	 * @return {@code true} if this set is a subset of set B
	 */
	public boolean isSubsetOf(SetElement B) {
		
		if(this.getSize() > B.getSize())
			return false;
		
		for(Element e : set)
			if(!B.contains(e))
				return false;
		
		return true;
		
	}
	
	/**
	 * A is a proper subset of B if A is a subset of B,
	 * and there is at least one element in B that is not in A.<p>
	 * A ⊂ B ⇔ (A ⊆ B) ∧ (B - A ≠ {})
	 * 
	 * @param B - a set of elements
	 * @return {@code true} if this set is a proper subset of set B
	 */
	public boolean isProperSubsetOf(SetElement B) {
		
		if(this.getSize() >= B.getSize() || !this.isSubsetOf(B))
			return false;
		
		for(Element e : B.getSet())
			if(!this.contains(e))
				return true;
		
		return false;
		
	}
	
	/**
	 * Tests if this set is a set containing only tuples of 2 elements.
	 * 
	 * @return {@code true} if set only contains 2-tuple elements
	 */
	public boolean isCoupleSet() {
		
		for(Element e : set) {
			if(!TupleElement.class.isAssignableFrom(e.getClass()))
				return false;
			if(((TupleElement) e).getLength() != 2)
				return false;
		}
		
		return true;
		
	}
	
	/**
	 * Returns the first value of each tuple in this set as a new set of elements.
	 * 
	 * @return set of x-values from this set
	 */
	public SetElement getDomain() {
		
		SetElement domain = new SetElement();
		
		for(Element e : set) {
			if(TupleElement.class.isAssignableFrom(e.getClass())) {
				Element x = ((TupleElement) e).getElement(0);
				domain.add(x);
			}
		}
		
		return domain;
		
	}
	
	/**
	 * Returns the second value of each tuple in this set as a new set of elements.
	 * 
	 * @return set of y-values from this set
	 */
	public SetElement getCodomain() {
		
		SetElement codomain = new SetElement();
		
		for(Element e : set) {
			if(TupleElement.class.isAssignableFrom(e.getClass())) {
				Element y = ((TupleElement) e).getElement(1);
				codomain.add(y);
			}
		}
		
		return codomain;
		
	}
	
	/**
	 * Tests whether the set is a function of the domain X and codomain Y.<p>
	 * A set is a function if it is a subset of the product between X and Y,
	 * and there is one and only one element representing each domain value.<p>
	 * (F ⊆ X x Y) ∧ (∀e ∈ X( |{ (e, q) | ( (e, q) ∈ F ) }| = 1))
	 * 
	 * @param X - domain
	 * @param Y - codomain
	 * @return {@code true} if this set is a function of the domain and codomain
	 */
	public boolean isFunction(SetElement X, SetElement Y) {
		
		if(!isCoupleSet())
			return false;
		
		SetElement domain = getDomain();
		SetElement codomain = getCodomain();
				
		// All x elements are in the domain of X
		if(!X.containsAll(domain)) 
			return false;
		
		// All y elements are in the domain of Y
		if(!Y.containsAll(codomain))
			return false;
		
		// All x elements in the domain of X are mapped in S
		if(!domain.containsAll(X))
			return false;
		
		return true;
		
	}
	
	/**
	 * For a set to be a function, it must be a set of tuple elements, 
	 * and there must be one and only one element that represents each domain value.<p>
	 * Assumes the domain and codomain from set values.
	 * 
	 * @return true if this set is a function
	 */
	public boolean isFunction() {
		
		SetElement domain = getDomain();
		SetElement codomain = getCodomain();	
		
		return isFunction(domain, codomain);
		
	}
	
	/**
	 * For a set to be an injective function, it must be a function,
	 * and there must be at most one element that represents each codomain value.
	 * 
	 * @param X - domain
	 * @param Y - codomain
	 * @return {@code true} if this set is an injective function
	 */
	public boolean isInjection(SetElement X, SetElement Y) {
		
		if(!isFunction(X, Y))
			return false;
		
		// test codomain elements for uniqueness
		SetElement codomain = new SetElement();
		for(Element e : set) {
			Element y = ((TupleElement) e).getElement(1);
			if(!codomain.add(y))
				return false;
		}
			
		return true;
		
	}
	/**
	 * For a set to be an injective function, it must be a function,
	 * and there must be at most one element that represents each codomain value.<p>
	 * Assumes the domain and codomain from set values.
	 * 
	 * @return {@code true} if this set is an injective function
	 */
	public boolean isInjection() {
		
		SetElement domain = getDomain();
		SetElement codomain = getCodomain();
				
		return isInjection(domain, codomain);
		
	}
	
	/**
	 * For a set to be a surjective function, it must be a function,
	 * and there must be at least one element that represents each codomain value.
	 * 
	 * @param X - domain
	 * @param Y - codomain
	 * @return true if set is a surjective function
	 */
	public boolean isSurjection(SetElement X, SetElement Y) {
		
		if(!isFunction(X, Y))
			return false;
		
		SetElement codomain = getCodomain();
		
		// test for presence of entire codomain Y
		if(!codomain.containsAll(Y))
			return false;
		
		return true;
		
	}
	
	/**
	 * For a set to be a bijective function, it must be a function,
	 * and there must be one and only one element that represents each codomain value.
	 * 
	 * @param X - domain
	 * @param Y - codomain
	 * @return {@code true} if this set is a bijective function
	 */
	public boolean isBijection(SetElement X, SetElement Y) {
		
		if(!isFunction(X, Y))
			return false;
		
		SetElement codomain = new SetElement();
		// test codomain elements for uniqueness
		for(Element e : set) {
			Element y = ((TupleElement) e).getElement(1);
			if(!codomain.add(y))
				return false;
		}
		
		if(!codomain.containsAll(Y))
			return false;
		
		return true;
	}
	
	/**
	 * For a set to be a bijective function, it must be a function,
	 * and there must be one and only one element that represents each codomain value.<p>
	 * Assumes the domain and codomain from set values.
	 * 
	 * @param X - domain
	 * @param Y - codomain
	 * @return {@code true} if this set is a bijective function
	 */
	public boolean isBijection() {
		
		SetElement domain = getDomain();
		SetElement codomain = getCodomain();
		
		return isBijection(domain, codomain);
		
	}
	
	/**
	 * Inverts this set if it is set of 2-tuples. Else, returns null.
	 * 
	 * @return new set containing the inverse of this set
	 */
	public SetElement inverseFunction() {
		
		if(!isCoupleSet())
			return null;
		
		SetElement inverse = new SetElement();
		for(Element e : set) {
			TupleElement te = (TupleElement) e;
			Element x = te.getElement(0);
			Element y = te.getElement(1);
			inverse.add(new TupleElement(y, x));
		}
		
		return inverse;
		
	}
	
	@Override
	public boolean isEquivalentTo(Element e) {
		
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
				if(x.isEquivalentTo(y)) {
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
	public boolean isElementOf(SetElement S) {
		return S.contains(this);
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
