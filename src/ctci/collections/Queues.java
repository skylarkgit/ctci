package ctci.collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {
	public static void main(String[] args) {
		Queue<Integer> q;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(7);		// O(logn)
		pq.remove();	// O(logn)
		
		Deque<Integer> dq;
		LinkedList<Integer> lq = new LinkedList<>();
		lq.add(4);	// O(1)
		lq.remove(6); // O(1)
	}
}
