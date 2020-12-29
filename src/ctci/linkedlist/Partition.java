package ctci.linkedlist;

public class Partition {

	public static void partition(SinglyLinkedList<Integer> ll, int pivot) {
		Node<Integer> curr = ll.head;
		Node<Integer> prev = null;
		
		while (curr != null) {
			if (pivot > curr.value) {
				if (prev != null) {
					prev.next = curr.next;
					curr.next = ll.head;
					ll.head = curr;
					curr = prev;
				}
			}
			
			prev = curr;
			curr = curr.next;
		}
	}
	
	public static class SinglyLinkedList<T> {
		private Node<T> head;
		private Node<T> tail;
		
		public SinglyLinkedList<T> add(T value) {
			Node<T> node = new Node<>(value);
			if (head != null) {
				tail.next = node;
			} else {
				head = node;
			}
			tail = node;
			return this;
		}
	}
	
	public static class Node<T> {
		private T value;
		private Node<T> next;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		ll.add(5).add(6).add(8).add(4).add(1).add(11).add(2);
		print(ll.head);
		partition(ll, 0);
		print(ll.head);		
	}
	
	public static <T> void print(Node<T> node) {
		StringBuilder sb = new StringBuilder();
		while(node!= null) {
			sb.append(node.value);
			sb.append(' ');
			node = node.next;
		}
		System.out.println(sb.toString());
	}
}
