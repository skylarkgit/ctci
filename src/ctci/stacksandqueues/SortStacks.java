package ctci.stacksandqueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SortStacks {
	
	public static class SortStack {
		private LinkedList<Integer> s1;
		private LinkedList<Integer> s2;
		
		private void place(Integer item) {
			int popCount = 0;
			while(!s2.isEmpty() && s2.peek() < item) {
				s1.push(s2.pop());
			}
			s2.push(item);
			while(popCount-->0) {
				s1.push(s2.pop());
			}
		}
		
		public LinkedList<Integer> sort(LinkedList<Integer> stack) {
			s1 = stack;
			s2 = new LinkedList<>();
			
			while (!s1.isEmpty()) {
				place(s1.pop());
			}
			return s2;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> s1 = new LinkedList<>(Arrays.asList(5, 2, 9, 6, 1, 3 ,7, 32, 7, 23, 12 ,67, 34));
		System.out.println(String.join(", ", s1.stream().map(i -> i.toString()).collect(Collectors.toList())));
		SortStack ss = new SortStack();
		s1 = ss.sort(s1);
		System.out.println(String.join(", ", s1.stream().map(i -> i.toString()).collect(Collectors.toList())));
	}

}
