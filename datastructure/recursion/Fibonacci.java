package recursion;

public class Fibonacci {


    public static void main(String[] args) {
        int[] arrOfResults = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        System.out.println(findFibonacci(9, arrOfResults));
    }

    //Memoization (Top Down approach)
    private static int findFibonacci(int n, int[] a) {
        if (a[n] == -1) {
            if (n <= 1)
                a[n] = n;
            else {
                a[n] = findFibonacci(n - 1, a) + findFibonacci(n - 2, a);
            }
        }
        return a[n];
    }

    //Tabulation : Bottom up approach
    private static int findFibonacciTabulation(int n, int[] a) {
        a[0]=0;
        a[1] = 1;
        for(int i=2;i<=n ; i++)
            a[i] = a[i-1] + a[i-2];
        return a[n];
    }
}
