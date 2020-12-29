package ctci.linkedlist;

/**
 * #Cool
 * @author abhay-verma
 *
 */
public class DeletingMiddleNode {

	public static class SinglyLinkedList<T> {
		private Node<T> tail;
		private Node<T> head;
		
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
	
	public static void deleteNode(SinglyLinkedList<Integer> ll, Node<Integer> node) {
		Node<Integer> prev = null;
		Node<Integer> curr = ll.head;
		
		while (curr != null) {
			if (curr == node) {
				prev.next = node.next;
				return;
			}
			prev = curr;
			curr = curr.next;
		}
	}
	
	public static void deleteNode(Node<Integer> node) {
		node.value = node.next.value;
		node.next = node.next.next;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
		
		ll.add(4).add(6).add(2).add(9).add(8);
		
		printNodes(ll.head);
		
		deleteNode(ll.head.next.next.next);
		
		printNodes(ll.head);
		
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
