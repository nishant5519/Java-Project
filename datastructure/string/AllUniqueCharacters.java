package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllUniqueCharacters {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(uniqueCharacters(input));
	}

	static boolean checkCharacters(String s) {
		boolean isUnique = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					isUnique = false;

			}

		}
		return isUnique;
	}

	public static boolean isUniqueChars2(String str) {
		// Create a new boolean array of 256 characters to account for basic
		// ascii and extended ascii characters
		boolean[] char_set = new boolean[256];// initialize to false

		for (int i = 0; i < str.length(); i++) {

			// Get the numerical (ascii) value of the character in the `str` at
			// position `i`.
			int val = str.charAt(i);

			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	static boolean uniqueCharacters(String str)
    {
        // Assuming string can have characters a-z
        // this has 32 bits set to 0
        int checker = 0;
 
        for (int i=0; i<str.length(); i++)
        {
            int bitAtIndex = str.charAt(i)-'a';
 
            // if that bit is already set in checker,
            // return false
            int temp=1<<bitAtIndex;
            if ((checker & temp) > 0)
                return false;
 
            // otherwise update and continue by
            // setting that bit in the checker
            checker = checker | temp;
        }
 
        // no duplicates encountered, return true
        return true;
    }

}
