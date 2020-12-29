package ctci.stringandarrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import ctci.util.EntryImpl;

/**
 * Chapter 1 Question 6
 * @author abhay-verma
 *
 */
public class StringComparison {
	
	public static String compress(String s) {
		StringBuilder sb = new StringBuilder();
		List<Entry<Character, Integer>> charCounts = charCount(s);
		for (Entry<Character, Integer> entry: charCounts) {
			if (entry.getValue() > 2) {
				sb.append(entry.getKey());
				sb.append(entry.getValue());
			} else {
				for (int i = 0 ;i < entry.getValue(); i++) {
					sb.append(entry.getKey());
				}
			}
		}
		return sb.toString();
	}
	
	public static List<Entry<Character, Integer>> charCount(String s) {
		List<Entry<Character, Integer>> chars = new LinkedList<>();
		
		char currChar = 0;
		int currCount = 0;
		
		for (char c: s.toCharArray()) {
			if (currChar != 0 && c != currChar) {
				chars.add(new EntryImpl<>(currChar, currCount));
				currCount = 0;
			}
			currChar = c;
			currCount ++;
		}
		
		if (currChar != 0) {
			chars.add(new EntryImpl<>(currChar, currCount));
		}
		
		return chars;
	}
	
	public static String compress2(String s) {
		StringBuilder sb = new StringBuilder();
		
		char currChar = 0;
		int currCount = 0;
		
		for (char c: s.toCharArray()) {
			if (currChar != 0 && c != currChar) {
				putSb(sb, currChar, currCount);
				currCount = 0;
			}
			currChar = c;
			currCount ++;
		}
		
		if (currChar != 0) {
			putSb(sb, currChar, currCount);
		}
		
		return sb.toString();
	}
	
	private static void putSb(StringBuilder sb, char c, int count) {
		if (count > 2) {
			sb.append(c);
			sb.append(count);
		} else {
			for (int i = 0 ;i < count; i++) {
				sb.append(c);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(compress("aaabbbbbccddd"));
		System.out.println(compress2("aaabbbbbccddd"));
		System.out.println(compress2("abcde"));
	}
}

