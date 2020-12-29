package ctci.linkedlist;

/**
 * #Cool
 * @author abhay-verma
 *
 */
public class KthFromLast {

	private static Integer getKthFromLast(SinglyLinkedList<Integer> ll, int k) {
		int size = 0;
		Node<Integer> node = ll.getHead();
		while (node != null) {
			node = node.getNext();
			size++;
		}
		
		System.out.println("Size = " + size);
		
		int i = size - k;
		node = ll.getHead();
		while (node != null && i-- > 0) {
			node = node.getNext();
		}
		return node == null ? null : node.getValue();
	}
	
	private static Integer theValue = null;
	private static Integer getKthFromLastRecursion(SinglyLinkedList<Integer> ll, int k) {
		getKthFromLastHelper(ll.head, k);
		Integer temp = theValue;
		theValue = null;
		return temp;
	}
	
	private static Integer getKthFromLastHelper(Node<Integer> node, int k) {
		if (node == null) return 0;
		int index = 1 + getKthFromLastHelper(node.getNext(), k);
		if (index == k) theValue = node.getValue();
		return index;
	}
	
	private static Integer getKthFromLastIterative(SinglyLinkedList<Integer> list, int k) {
		Node<Integer> p1 = list.getHead();
		while (k-- > 0) {
			p1 = p1.getNext();
		}
		
		Node<Integer> p2 = list.getHead();
		while (p1 != null) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		return p2.value;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		ll.add(5).add(6).add(8).add(1).add(34).add(23).add(213);
		int k = 2;
		System.out.println(getKthFromLast(ll, k));
		System.out.println(getKthFromLastRecursion(ll, k));
		System.out.println(getKthFromLastIterative(ll, k));
	}
	
	
	public static class SinglyLinkedList<T> {
		private Node<T> head;
		private Node<T> tail;
		
		public SinglyLinkedList<T> add(T value) {
			Node<T> node = new Node<>(value);
			if (tail != null) {
				tail.next = node;
			} else {
				head = node;
			}
			tail = node;
			return this;
		}

		public Node<T> getHead() {
			return head;
		}
	}
	
	public static class Node<T> {
		private T value;
		private Node<T> next;
		public T getValue() {
			return value;
		}
		public Node<T> setValue(T value) {
			this.value = value;
			return this;
		}
		public Node<T> getNext() {
			return next;
		}
		public Node<T> setNext(Node<T> next) {
			this.next = next;
			return this;
		}
		public Node(T value) {
			super();
			this.value = value;
		}
		public boolean hasNext() {
			return next != null;
		}
	}
}
