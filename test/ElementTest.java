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
		
		A.remove("2");
		B.remove("2");
		
		System.out.println();
		System.out.println("A - {2} = " + A.toString());
		System.out.println("B - {2} = " + B.toString());
		System.out.println("2 exists in A - {2} = " + A.contains("2"));
		System.out.println("2 exists in B - {2} = " + B.contains("2"));
		
		B.add("2");
		
		System.out.println();
		System.out.println("A intersection B = " + A.intersection(B));
		System.out.println("A union B = " + A.union(B));
		System.out.println("A - B = " + A.difference(B));
		System.out.println("B - A = " + B.difference(A));
		System.out.println("A x B = " + A.product(B));
		System.out.println("A is subset of B = " + A.isSubset(B));
		System.out.println("A is subset of A = " + A.isSubset(A));
		System.out.println("A is proper subset of B = " + A.isProperSubset(B));
		System.out.println("A is proper subset of A = " + A.isProperSubset(A));
		
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
		System.out.println("E is subset of F = " + E.isSubset(F));
		System.out.println("F is subset of E = " + F.isSubset(E));
		System.out.println("E is proper subset of F = " + E.isProperSubset(F));
		System.out.println("F is proper subset of E = " + F.isProperSubset(E));
		
		SetElement empty = new SetElement();
		
		System.out.println();
		System.out.println("|{}| = " + empty.getSize());
		System.out.println("{} intersection {} = " + empty.intersection(empty));
		System.out.println("{} union {} = " + empty.union(empty));
		System.out.println("{} - {} = " + empty.difference(empty));
		System.out.println("{} x {} = " + empty.product(empty));
		System.out.println("{} is subset of {} = " + empty.isSubset(empty));
		System.out.println("{} is proper subset of {} = " + empty.isProperSubset(empty));
	}

}