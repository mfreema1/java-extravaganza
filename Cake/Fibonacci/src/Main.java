import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Fib: " + fib(5) + ", total calls: " + fibCalls);
        System.out.println("Fib top down: " + fibLinearTopDown(5) + ", total calls: " + fibTopDownCalls);
        System.out.println("Fib bottom up: " + fibLinearBottomUp(5));
        System.out.println("Fib low space: " + fibLowSpace(5));
    }

    static int fibCalls = 0;
    public static int fib(int n) {
        fibCalls++;
        if(n == 0 || n == 1) {
            return n;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static int fibTopDownCalls = 0;
    static Map<Integer, Integer> memo = new HashMap<Integer, Integer>(){{ put(0, 0); put(1, 1); }};
    public static int fibLinearTopDown(int n) {
        fibTopDownCalls++;
        if(memo.get(n) != null) {
            return memo.get(n);
        }
        else {
            int fib = fibLinearTopDown(n - 1) + fibLinearTopDown(n - 2);
            memo.put(n, fib);
            return fib;
        }
    }

    //not counting calls, we know it's 1
    public static int fibLinearBottomUp(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static int fibLowSpace(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int a = 0, b = 1, c = 1;
        for(int i = 2; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
