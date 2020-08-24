package com.datastructure.array;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class FindFirstNonRepetitiveCharacterinGivenString {

	public static void main(String[] args) {
		String str = "abscbdab";
		System.out.println(findCharacter(str));

	}

	public static char findCharacter(String str) {

		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		Character result = null;
		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				result = entry.getKey();
				break;
			}
		}
		return result;

	}

	@Test
	public void testFirstNonRepeatedCharacter() {
		assertEquals('b', FindFirstNonRepetitiveCharacterinGivenString.findCharacter("abcdefghija"));
		assertEquals('h', FindFirstNonRepetitiveCharacterinGivenString.findCharacter("hello"));
		assertEquals('J', FindFirstNonRepetitiveCharacterinGivenString.findCharacter("Java"));
		assertEquals('i', FindFirstNonRepetitiveCharacterinGivenString.findCharacter("simplest"));
	}

}
