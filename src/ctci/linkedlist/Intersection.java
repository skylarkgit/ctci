package ctci.linkedlist;

public class Intersection {
	
	
	public static<T> Node<T> intersection(L<T> a, L<T> b) {
		Node<T> ptr1 = a.head;
		Node<T> ptr2 = b.head;
		int size = Math.min(a.size, b.size);
		ptr1 = moveForward(ptr1, a.size - size);
		ptr2 = moveForward(ptr2, b.size - size);
		
		while(ptr1 != null) {
			if (ptr1 == ptr2) {
				return ptr1;
			}
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return null;
	}
	
	public static class Node<T> {
		private Node<T> next;
		private T value;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	public static class L<T> {
		private Node<T> head;
		private Node<T> tail;
		private int size;
		
		public L<T> add(T value) {
			Node<T> node = new Node<>(value);
			if (head == null) {
				head = node;
			} else {
				tail.next = node;
			}
			tail = node;
			size++;
			return this;
		}
		
		public L<T> add(Node<T> node) {
			if (head == null) {
				head = node;
			} else {
				tail.next = node;
			}
			while (node.next != null) {
				node = node.next;
				size++;
			}
			tail = node;
			size++;
			return this;
		}
	}
	
	public static <T> Node<T> moveForward(Node<T> node, int k) {
		while (k-- > 0 && node != null) {
			node = node.next;
		}
		return node;
	}
	
	public static void main(String[] args) {
		L<Integer> ll1 = new L<>();
		ll1.add(1).add(2).add(3).add(4).add(5).add(6).add(7);
		L<Integer> ll2 = new L<>();
		ll2.add(100).add(ll1.head.next.next.next);
		printNodes(ll1.head);
		printNodes(ll2.head);
		Node<Integer> iNode = intersection(ll1,  ll2);
		System.out.println(iNode == null ? "null" : iNode.value);
	}
	
	public static <T> void printNodes(Node<T> node) {
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.value);
			sb.append(' ');
			node = node.next;
		}
		System.out.println(sb.toString());
	}
}
