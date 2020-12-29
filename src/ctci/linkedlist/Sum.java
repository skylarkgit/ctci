package ctci.linkedlist;

public class Sum {

	public static SinglyLinkedList<Integer> sum(SinglyLinkedList<Integer> l1, SinglyLinkedList<Integer> l2) {
		Node<Integer> ptr1 = l1.head;
		Node<Integer> ptr2 = l2.head;

		Integer carry = 0;

		SinglyLinkedList<Integer> output = new SinglyLinkedList<>();

		while (ptr1 != null || ptr2 != null || carry > 0) {
			Integer a = ptr1 == null ? 0 : ptr1.value;
			Integer b = ptr2 == null ? 0 : ptr2.value;

			Integer s = a + b + carry;

			output.add(s % 10);
			carry = s >= 10 ? 1 : 0;

			ptr1 = ptr1 == null ? null : ptr1.next;
			ptr2 = ptr2 == null ? null : ptr2.next;
		}

		return output;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
		l1.add(7).add(1).add(6);
		SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
		l2.add(5).add(9).add(2);
		
		System.out.println("l1");
		printNodes(l1.head);
		
		System.out.println("l2");
		printNodes(l2.head);
		
		System.out.println("sum = ");
		printNodes(sum(l1, l2).head);
	}

	public static class SinglyLinkedList<T> {
		private Node<T> head;
		private Node<T> tail;

		public SinglyLinkedList<T> add(T value) {
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

	public static class Node<T> {
		private T value;
		private Node<T> next;

		public Node(T value) {
			super();
			this.value = value;
		}
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
