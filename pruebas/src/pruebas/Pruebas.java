package pruebas;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Pruebas {

	public static void main(String[] args) {
//		List<Integer> l1=List.of(1,null,3,1);
//		Set<Integer> st=new HashSet(l1);
//		System.out.println(st.size());
		
//		var numA = new Integer[] {2,3,5};
//		var list1 = List.of(numA);
//		var list2 = Collections.unmodifiableList(list1);
//		numA[1] = 8; 
//		System.out.println(list1 + " " + list2);
		
		Collection<Number> col = new HashSet();
		col.add(1);
		var list1 = List.of(col);
		col.add(2);
		var list2 = List.copyOf(col);
		System.out.println(list1 + " " + list2);
		

	}

}
