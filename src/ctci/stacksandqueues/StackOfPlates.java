package ctci.stacksandqueues;

import java.util.ArrayList;
import java.util.LinkedList;

public class StackOfPlates {
	public static class SetOfStacks<T> {
		private ArrayList<Stack<T>> listOfStack = new ArrayList<>();
		private int size = 0;
		private int ms;
		
		public SetOfStacks(int maxSize) {
			ms = maxSize;
		}
		
		public SetOfStacks<T> push(T a) {
			if (isLastFull()) {
				listOfStack.add(new Stack<>());
			}
			getLastStack().push(a);
			size++;
			return this;
		}
		
		public T pop() {
			T a = getLastStack().pop();
			size--;
			if (isLastFull()) {
				listOfStack.remove(listOfStack.size() - 1);
			}
			return a;
		}
		
		public T peek() {
			return getLastStack().peek();
		}
		
		public T peek(int i) {
			return listOfStack.get(i).peek();
		}
		
		public boolean isLastFull() {
			return (size % ms) == 0;
		}
		
		private Stack<T> getLastStack() {
			return listOfStack.get(listOfStack.size() - 1); 
		}
		
		private void debug() {
			for (Stack<T> st: listOfStack) {
				System.out.print(st);
				System.out.print(" : ");
				for (T t: st.list) {
					System.out.print(t);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
	
	public static class Stack<T> {
		private LinkedList<T> list = new LinkedList<>();
		
		public void push(T a) {
			list.push(a);
		}
		
		public T pop() {
			return list.pop();
		}
		
		public T peek() {
			return list.peek();
		}
		
		public int getSize() {
			return list.size();
		}
	}
	
	public static void main(String[] args) {
		SetOfStacks<Integer> set = new SetOfStacks<>(3);
		set.push(5);
		set.push(6);
		set.push(7);
		
		set.push(8);
		set.push(9);
		set.push(10);
		
		set.push(1);
		set.push(2);
		set.push(3);
		
		set.debug();
		
		while(set.size > 0) {
			System.out.println(set.pop());
		}
		
		set.debug();
		
		set.push(5);
		set.push(6);
		set.push(7);
		
		set.push(8);
		set.push(9);
		set.push(10);
		
		set.push(1);
		set.push(2);
		set.push(3);
		
		set.debug();
		
		while(set.size > 0) {
			System.out.println(set.pop());
		}
		
		set.debug();
	}
}
