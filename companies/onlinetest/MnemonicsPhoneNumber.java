package companies.onlinetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MnemonicsPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations("234"));
	}

	static public List<String> letterCombinations(String digits) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "0");
		map.put(1, "1");
		map.put(2, "ABC");
		map.put(3, "DEF");
		map.put(4, "GHI");
		map.put(5, "JKL");
		map.put(6, "MNO");
		map.put(7, "PQRS");
		map.put(8, "TUV");
		map.put(9, "WXYZ");

		ArrayList<String> result = new ArrayList<String>();

		if (digits == null || digits.length() == 0)
			return result;

		ArrayList<Character> temp = new ArrayList<Character>();
		getString(digits, temp, result, map);
		System.out.println("List size is :" + result.size());

		return result;
	}

	static public void getString(String digits, ArrayList<Character> temp, ArrayList<String> result,
			HashMap<Integer, String> map) {
		if (digits.length() == 0) {
			char[] arr = new char[temp.size()];
			for (int i = 0; i < temp.size(); i++) {
				arr[i] = temp.get(i);
			}
			result.add(String.valueOf(arr));
			return;
		}

		String letters = map.get(Integer.valueOf(digits.substring(0, 1)));
		for (int i = 0; i < letters.length(); i++) {
			temp.add(letters.charAt(i));
			getString(digits.substring(1), temp, result, map);
			temp.remove(temp.size() - 1);
		}
	}

}