import com.github.nes370.sets.*;

public class ElementTest {

	public static void main(String[] args) {
		
		SetElement A = new SetElement();
		A.add("a");
		A.add("b");
		A.add("c");
		
		SetElement B = new SetElement();
		B.add("1");
		B.add("2");
		B.add("3");
		
		System.out.println("A = " + A.toString());
		System.out.println("B = " + B.toString());
		System.out.println("|A| = " + A.getSize());
		System.out.println("|B| = " + B.getSize());
		System.out.println("2 exists in A = " + A.contains("2"));
		System.out.println("2 exists in B = " + B.contains("2"));
		
		SetElement C = A.generateSubsets();
		SetElement D = B.generateSubsets();
		
		System.out.println();
		System.out.println("C = {N|N subset A} = " + C.toString());
		System.out.println("D = {N|N subset B} = " + D.toString());
		
		SetElement copyA = new SetElement();
		copyA.addAll(A);
		SetElement copyB = new SetElement();
		copyB.addAll(B);
		
		copyA.remove("2");
		copyB.remove("2");
		
		System.out.println();
		System.out.println("A - {2} = " + copyA.toString());
		System.out.println("B - {2} = " + copyB.toString());
		System.out.println("2 exists in A - {2} = " + copyA.contains("2"));
		System.out.println("2 exists in B - {2} = " + copyB.contains("2"));
		System.out.println("(A - {2}) is subset of A = " + copyA.isSubsetOf(A));
		System.out.println("(B - {2}) is subset of B = " + copyB.isSubsetOf(B));
		System.out.println("(A - {2}) is proper subset of A = " + copyA.isProperSubsetOf(A));
		System.out.println("(B - {2}) is proper subset of B = " + copyB.isProperSubsetOf(B));
		
		System.out.println();
		System.out.println("A intersection B = " + A.intersection(B));
		System.out.println("A union B = " + A.union(B));
		System.out.println("A - B = " + A.difference(B));
		System.out.println("B - A = " + B.difference(A));
		System.out.println("A x B = " + A.product(B));
		System.out.println("A is subset of B = " + A.isSubsetOf(B));
		System.out.println("A is subset of A = " + A.isSubsetOf(A));
		System.out.println("A is proper subset of B = " + A.isProperSubsetOf(B));
		System.out.println("A is proper subset of A = " + A.isProperSubsetOf(A));
		
		SetElement E = new SetElement();
		E.add("a");
		E.add("2");
		E.add("c");
		
		SetElement F = new SetElement();
		F.add("1");
		F.add("2");
		F.add("b");
		
		System.out.println();
		System.out.println("E = " + E.toString());
		System.out.println("F = " + F.toString());
		
		System.out.println();
		System.out.println("E intersection F = " + E.intersection(F));
		System.out.println("|E intersection F| = " + E.intersection(F).getSize());
		System.out.println("E union F = " + E.union(F));
		System.out.println("|E union F| = " + E.union(F).getSize());
		System.out.println("E - F = " + E.difference(F));
		System.out.println("|E - F| = " + E.difference(F).getSize());
		System.out.println("F - E = " + F.difference(E));
		System.out.println("|F - E| = " + F.difference(E).getSize());
		System.out.println("E x F = " + E.product(F));
		System.out.println("|E x F| = " + E.product(F).getSize());
		System.out.println("E is subset of F = " + E.isSubsetOf(F));
		System.out.println("F is subset of E = " + F.isSubsetOf(E));
		System.out.println("E is proper subset of F = " + E.isProperSubsetOf(F));
		System.out.println("F is proper subset of E = " + F.isProperSubsetOf(E));
		
		SetElement empty = new SetElement();
		
		System.out.println();
		System.out.println("|{}| = " + empty.getSize());
		System.out.println("{} intersection {} = " + empty.intersection(empty));
		System.out.println("{} union {} = " + empty.union(empty));
		System.out.println("{} - {} = " + empty.difference(empty));
		System.out.println("{} x {} = " + empty.product(empty));
		System.out.println("{} is subset of {} = " + empty.isSubsetOf(empty));
		System.out.println("{} is proper subset of {} = " + empty.isProperSubsetOf(empty));
		
		SetElement G = new SetElement();
		StringElement[] t = new StringElement[2];
		t[0] = new StringElement("a");
		t[1] = new StringElement("1");
		String[] u = {"a", "2"};
		G.add(new TupleElement(t));
		G.add(new TupleElement(u));
		
		SetElement X = new SetElement();
		X.add("a");
		X.add("b");
		
		SetElement Y = new SetElement();
		Y.add("1");
		Y.add("2");
		Y.add("3");
		
		System.out.println();
		System.out.println("Domain is " + X);
		System.out.println("Codomain is " + Y);
		
		System.out.println();
		System.out.println("G = " + G);
		System.out.println("G is a function: " + G.isFunction(X, Y));
		System.out.println("G is injective: " + G.isInjection(X, Y));
		System.out.println("G is surjective: " + G.isSurjection(X, Y));
		System.out.println("G is bijective: " + G.isBijection(X, Y));
		
		SetElement H = new SetElement();
		H.add(new TupleElement("a", "1"));
		H.add(new TupleElement("b", "1"));
		
		System.out.println();
		System.out.println("H = " + H);
		System.out.println("H is a function: " + H.isFunction(X, Y));
		System.out.println("H is injective: " + H.isInjection(X, Y));
		System.out.println("H is surjective: " + H.isSurjection(X, Y));
		System.out.println("H is bijective: " + H.isBijection(X, Y));
		
		SetElement I = new SetElement();
		I.add(new TupleElement("a", "1"));
		I.add(new TupleElement("b", "2"));
		
		System.out.println();
		System.out.println("I = " + I);
		System.out.println("I is a function: " + I.isFunction(X, Y));
		System.out.println("I is injective: " + I.isInjection(X, Y));
		System.out.println("I is surjective: " + I.isSurjection(X, Y));
		System.out.println("I is bijective: " + I.isBijection(X, Y));
		
		Y.remove("3");
		
		System.out.println();
		System.out.println("Domain is " + X);
		System.out.println("Codomain is " + Y);
		
		SetElement J = new SetElement();
		J.add(new TupleElement("a", "1"));
		J.add(new TupleElement("b", "2"));
		
		System.out.println();
		System.out.println("J = " + J);
		System.out.println("J is a function: " + J.isFunction(X, Y));
		System.out.println("J is injective: "  + J.isInjection(X, Y));
		System.out.println("J is surjective: " + J.isSurjection(X, Y));
		System.out.println("J is bijective: "  + J.isBijection(X, Y));
		
		SetElement K = new SetElement();
		K.add(new TupleElement("a", "1"));
		K.add(new TupleElement("b", "1"));
		
		System.out.println();
		System.out.println("K = " + K);
		System.out.println("K is a function: " + K.isFunction(X, Y));
		System.out.println("K is injective: "  + K.isInjection(X, Y));
		System.out.println("K is surjective: " + K.isSurjection(X, Y));
		System.out.println("K is bijective: "  + K.isBijection(X, Y));
		
		SetElement arcJ = J.inverseFunction();
		SetElement arcK = K.inverseFunction();
		
		System.out.println();
		System.out.println("Domain is " + Y);
		System.out.println("Codomain is " + X);
		
		System.out.println();
		System.out.println("J^(-1) = " + arcJ);
		System.out.println("J^(-1) is a function: " + arcJ.isFunction(Y, X));
		System.out.println("J^(-1) is injective: "  + arcJ.isInjection(Y, X));
		System.out.println("J^(-1) is surjective: " + arcJ.isSurjection(Y, X));
		System.out.println("J^(-1) is bijective: "  + arcJ.isBijection(Y, X));
		
		System.out.println();
		System.out.println("K^(-1) = " + arcK);
		System.out.println("K^(-1) is a function: " + arcK.isFunction(Y, X));
		System.out.println("K^(-1) is injective: "  + arcK.isInjection(Y, X));
		System.out.println("K^(-1) is surjective: " + arcK.isSurjection(Y, X));
		System.out.println("K^(-1) is bijective: "  + arcK.isBijection(Y, X));
		
	}

}