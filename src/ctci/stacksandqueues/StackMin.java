package ctci.stacksandqueues;

import java.util.LinkedList;

public class StackMin {

	public static class Stack<T> {
		private LinkedList<T> list;

		public Stack() {
			list = new LinkedList<>();
		}

		public Stack<T> push(T a) {
			list.add(a);
			return this;
		}

		public T pop() {
			return list.removeLast();
		}

		public T peek() {
			return list.size() == 0 ? null : list.getLast();
		}
	}

	public static class MinStack<T extends Comparable<T>> {
		private Stack<T> stack;
		private Stack<T> minStack;

		public MinStack() {
			stack = new Stack<>();
			minStack = new Stack<>();
		}

		public MinStack<T> push(T a) {
			stack.push(a);
			minStack.push((minStack.peek() != null && a.compareTo(minStack.peek()) > 0) ? minStack.peek() : a);
			return this;
		}

		public T pop() {
			minStack.pop();
			return stack.pop();
		}

		public T peek() {
			return stack.peek();
		}

		public T min() {
			return minStack.peek();
		}
	}

	public static void main(String[] args) {
		MinStack<Integer> m = new MinStack<>();
		m.push(8);
		System.out.println(m.peek());
		System.out.println(m.min());
		
		m.push(9);
		System.out.println(m.peek());
		System.out.println(m.min());
		
		m.push(5);
		System.out.println(m.peek());
		System.out.println(m.min());
		
		m.push(10);
		System.out.println(m.peek());
		System.out.println(m.min());
		
		m.pop();
		System.out.println(m.peek());
		System.out.println(m.min());
		
		m.pop();
		System.out.println(m.peek());
		System.out.println(m.min());
		
		m.pop();
		System.out.println(m.peek());
		System.out.println(m.min());
		
	}
}
