package ctci.stacksandqueues;

import java.util.LinkedList;

public class QueueViaStack {

	public static class MyQueue<T> {
		private LinkedList<T> s1 = new LinkedList<>();
		private LinkedList<T> s2 = new LinkedList<>();
		
		public MyQueue<T> add(T a) {
			s1.push(a);
			return this;
		}
		
		public T remove() {
			popInto(s1, s2);
			T a = s2.pop();
			popInto(s2, s1);
			return a;
		}
		
		public T peek() {
			popInto(s1, s2);
			T a = s2.peek();
			popInto(s2, s1);
			return a;
		}
		
		public boolean isEmpty() {
			return s1.isEmpty();
		}
	}
	
	public static <T> void popInto(LinkedList<T> a, LinkedList<T> b) {
		while (!a.isEmpty()) {
			b.push(a.pop());
		}
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();
		q.add(5).add(6).add(7).add(8).add(9);
		assert(q.remove() == 5);
		assert(q.peek() == 6);
		assert(q.remove() == 6);
		assert(q.isEmpty() == false);
		
		q.add(15).add(16).add(17).add(18).add(19);
		assert q.remove() == 7;
		assert q.peek() == 8;
		assert q.remove() == 8;
	}
}
