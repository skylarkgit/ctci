package ctci.util;

import java.util.Map.Entry;

public class EntryImpl<K, V> implements Entry<K, V> {

	private K key;
	
	private V value;
	
	public EntryImpl(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V arg0) {
		value = arg0;
		return arg0;
	}

}
