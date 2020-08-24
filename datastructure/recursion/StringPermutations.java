package recursion;

import java.util.*;
import java.lang.*;
import java.io.*;

class StringPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        String str;
        t = sc.nextInt();
        while (t-- > 0) {
            str = sc.next();
            System.out.print(str);
            numOfPermutations(str, 0, str.length() - 1);

        }
    }

    static void numOfPermutations(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                numOfPermutations(str, l + 1, r);
                str = swap(str, l, i);
            }
        }

    }

    static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}