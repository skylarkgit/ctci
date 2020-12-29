package ctci.linkedlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class RemoveDups {

	public static void removeDups(List<Integer> numbers) {
		Set<Integer> s = new HashSet<>();
		ListIterator<Integer> li = numbers.listIterator();
		while (li.hasNext()) {
			Integer number = li.next();
			if (s.contains(number)) {
				li.remove();
			} else {
				s.add(number);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = new LinkedList<>(Arrays.asList(1, 2, 3, 5, 7, 5, 2, 3, 2, 2, 2, 4));
		System.out.println(numbers);
		removeDups(numbers);
		System.out.println("1 eternity later");
		System.out.println(numbers);
	}
}
