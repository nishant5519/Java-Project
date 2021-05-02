package recursion;

import java.util.Stack;

public class SortStackUsingRecursion {

    //time complexity is O(n2) and space complexity is O(n) because of call stack
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        sort(s);

    }


    public static Stack<Integer> sort(Stack<Integer> s) {
        //add code here.

        if (!s.isEmpty()) {

            int temp = s.pop();

            sort(s);

            rearrange(s, temp);

        }

        return s;

    }

    static void rearrange(Stack<Integer> stk, int num) {

        if (stk.isEmpty() || num > stk.peek()) {
            stk.push(num);
            return;
        }

        int temp = stk.pop();

        rearrange(stk, num);
        stk.push(temp);

    }
}
