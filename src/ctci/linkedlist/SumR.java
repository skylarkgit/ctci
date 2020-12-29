package ctci.linkedlist;

public class SumR {
	
	public static L<Integer> sum(L<Integer> l1, L<Integer> l2) {
		int size = Math.max(l1.size, l2.size);
		l1.pad(size - l1.size, 0);
		l2.pad(size - l2.size, 0);
		
		L<Integer> res = new L<Integer>();
		int carry = sumR(l1.head, l2.head, res);
		if (carry > 0) res.push(1);
		return res;
	}
	
	public static int sumR(Node<Integer> ln1, Node<Integer> ln2, L<Integer> ll) {
		if (ln1 == null) return 0;
		int carry = sumR(ln1.next, ln2.next, ll);
		int s = carry + ln1.value + ln2.value;
		ll.push(s % 10);
		return s > 9 ? 1 : 0;
	}
	
	public static class L<T> {
		private Node<T> head;
		private Node<T> tail;
		private int size;
		
		public L<T> add(T value) {
			Node<T> node = new Node<>(value);
			if (head != null) {
				tail.next = node;
			} else {
				head = node;
			}
			tail = node;
			size++;
			return this;
		}
		
		public L<T> push(T value) {
			Node<T> node = new Node<>(value);
			node.next = head;
			head = node;
			if (tail == null) {
				tail = head;
			}
			size++;
			return this;
		}
		
		public L<T> pad(int k, T value) {
			while (k-- > 0) {
				push(value);
			}
			return this;
		}
	}
	
	public static class Node<T> {
		private Node<T> next;
		private T value;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		L<Integer> l1 = new L<>();
		l1.add(6).add(6).add(1).add(7);
		L<Integer> l2 = new L<>();
		l2.add(4).add(2).add(3).add(8);
		
		System.out.println("l1");
		printNodes(l1.head);
		
		System.out.println("l2");
		printNodes(l2.head);
		
		System.out.println("sum = ");
		printNodes(sum(l1, l2).head);
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
