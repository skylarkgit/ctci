package ctci.linkedlist;

public class LoopDetection {

	public static class Node<T> {
		T value;
		Node<T> next;
		
		Node (T value) {
			this.value = value; 
		}
	}
	
	public static <T> Node<T> detector (Node<T> head) {
		Node<T> fp = head;
		Node<T> sp = head;
		
		do {
			fp = fp.next.next;
			sp = sp.next;
		} while(fp != sp);
		
		sp = head;
		while(sp!=fp) {
			fp = fp.next;
			sp = sp.next;
		}
		
		return sp;
	}
	
	public static void main(String[] args) {
		Node<Integer> n = new Node<>(1);
		Node<Integer> head = n;
		n.next = new Node<>(2);
		n = n.next;
		
		n.next = new Node<>(3);
		n = n.next;
		
		Node<Integer> loop = new Node<>(4);
		n.next = loop;
		n = n.next;
		
		n.next = new Node<>(5);
		n = n.next;
		
		n.next = new Node<>(6);
		n = n.next;
		
		n.next = new Node<>(7);
		n = n.next;
		
		n.next = new Node<>(8);
		n = n.next;
		
		n.next = new Node<>(9);
		n = n.next;
		n.next = loop;
		
		head = detector(head);
		System.out.println(head.value);
	}
}
