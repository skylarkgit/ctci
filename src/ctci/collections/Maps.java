package ctci.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class Maps {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(5); // O(1)
		ll.add(4);
		ll.add(34);
		ll.get(3); // O(n)
		ll.add(6, 1); // O(1)

		Vector<Integer> v = new Vector<>();
		v.add(7); // O(1)
		v.add(9);
		v.insertElementAt(5, 1); // O(n)
		v.get(2); // O(1)
		v.add(2, 2); // O(n)

		ArrayList<Integer> al = new ArrayList<>();
		al.add(4);	// O(1)
		al.add(7);
		al.add(1);
		al.add(6, 2);	// O(n)
		al.get(2); // O(1)
		
		Stack<Integer> s = new Stack<>();
		s.push(5);	// O(1)
		s.push(7);	// O(1)
		s.pop();	// O(1)
		s.peek();	// O(1)
		s.get(5); 	// O(1)
		
	}

}
