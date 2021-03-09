package ctci.gs;

import java.util.ArrayList;

public class HIndexStream {
	
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(5);
		bst.add(4);
		bst.add(3);
		bst.add(6);
		bst.add(8);
		bst.add(7);
		bst.add(7);
		bst.add(7);
		bst.add(7);
		bst.add(7);
		bst.add(7);
		bst.add(7);
		bst.print();
		System.out.println("-----------------------------");
		bst.balance();
		bst.print();
	}
}

class BST<T extends Comparable<T>> {
	
	Node<T> root;
	int size;
	
	public void add(T value) {
		root = add(root, value);
		size++;
	}
	
	private Node<T> add(Node<T> current, T value) {
		if (current == null) {
			return new Node<>(value);
		}
		
		if (current.value.compareTo(value) > 0) {
			current.left = add(current.left, value);
		} else {
			current.right = add(current.right, value);
		}
		
		return current;
	}
	
	public void balance() {
		ArrayList<Node<T>> nodes = new ArrayList<>(size);
		inorder(root, nodes);
		root = reorder(nodes, 0, size - 1);
	}
	
	private Node<T> reorder(ArrayList<Node<T>> nodes, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start+end) / 2;
		Node<T> node = nodes.get(mid);
		node.left = reorder(nodes, start, mid - 1);
		node.right = reorder(nodes, mid + 1, end);
		return nodes.get(mid);
	}
	
	private void inorder(Node<T> node, ArrayList<Node<T>> nodes) {
		if (node == null) {
			return;
		}
		
		inorder(node.left, nodes);
		nodes.add(node);
		inorder(node.right, nodes);
	}
	void print() {
		print(root);
	}
	void print(Node<T> node) {
		if (node == null) {
			return;
		}
		System.out.println(getOrDefault(node.left, new Node<>()).value + " < " + node.value + " > " + getOrDefault(node.right, new Node<>()).value);
		print(node.left);
		print(node.right);
	}
	
	static <P> P getOrDefault(P p, P def) {
		return p == null ? def : p;
	}
}

class Node<T extends Comparable<T>> {
	
	Node<T> left;
	Node<T> right;
	T value;
	public Node() {
	}
	public Node(T value) {
		this.value = value;
	}
}