package ctci.stacksandqueues;

import java.util.LinkedList;

public class AnimalShelter {

	public static class Sequenced<T> {
		private T item;
		private int sequence;

		private static int seq = 0;

		public Sequenced(T item) {
			this.item = item;
			this.sequence = ++seq;
		}
	}

	public static interface Animal {}
	public static class Dog implements Animal {}
	public static class Cat implements Animal {}

	LinkedList<Sequenced<Dog>> dogs = new LinkedList<>();
	LinkedList<Sequenced<Cat>> cats = new LinkedList<>();
	
	public void enqueue(Animal animal) {
		if (animal instanceof Dog) {
			dogs.add(new Sequenced<Dog>((Dog)animal));
		} else {
			cats.add(new Sequenced<Cat>((Cat)animal));
		}
	}
	
	public Animal dequeueAny() {
		if (!dogs.isEmpty() && !cats.isEmpty()) {
			if (dogs.peek().sequence < cats.peek().sequence) {
				return dequeueDog();
			} else {
				return dequeueCat();
			}
		}
		
		if (!dogs.isEmpty()) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
	
	public Dog dequeueDog() {
		return dogs.remove().item;
	}
	
	public Cat dequeueCat() {
		return cats.remove().item;
	}
	
	public boolean isEmpty() {
		return dogs.isEmpty() && cats.isEmpty();
	}

	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(new Dog());
		shelter.enqueue(new Dog());
		shelter.enqueue(new Dog());
		shelter.enqueue(new Cat());
		shelter.enqueue(new Cat());
		shelter.enqueue(new Cat());
		shelter.enqueue(new Dog());
		shelter.enqueue(new Dog());
		
		while (!shelter.isEmpty()) {
			System.out.println(shelter.dequeueAny().getClass().getName());
		}
		
		shelter.enqueue(new Dog());
		shelter.enqueue(new Dog());
		shelter.enqueue(new Dog());
		shelter.enqueue(new Cat());
		shelter.enqueue(new Cat());
		shelter.enqueue(new Cat());
		shelter.enqueue(new Dog());
		shelter.enqueue(new Dog());
		
		while (!shelter.isEmpty()) {
			System.out.println(shelter.dequeueAny().getClass().getName());
		}
	}
}
