package array;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


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

	

}
