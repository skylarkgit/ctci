package ctci.linkedlist;

public class Palindrome {
	
	public static <T> boolean checkPalin(L<T> l) {
		Iter<T> iter = new Iter<T>();
		iter.ptr = l.head;
		return checkPalin(iter, l.head);
	}
	
	public static class Iter<T> {
		private Node<T> ptr;
		
		public Iter<T> next() {
			ptr = ptr.next;
			return this;
		}
	}
	
	public static class Node<T> {
		private Node<T> next;
		private T value;
		
		public Node(T v) {
			value = v;
		}
	}
	
	public static <T> boolean checkPalin(Iter<T> iter, Node<T> last) {
		if (last == null) {
			return true;
		}
		
		boolean v = checkPalin(iter, last.next);
		v = v && iter.ptr.value.equals(last.value);
		iter.next();
		return v;
	}
	
	public static class L<T> {
		private Node<T> head;
		private Node<T> tail;
		
		public L<T> add(T value) {
			Node<T> node = new Node<>(value);
			if (head == null) {
				head = node;
			} else {
				tail.next = node;
			}
			tail = node;
			return this;
		}
	}
	
	public static void main(String[] args) {
		L<Integer> l = new L<>();
		l.add(5).add(5).add(5).add(5).add(5).add(5).add(4);
		System.out.println(checkPalin(l));
	}
}
