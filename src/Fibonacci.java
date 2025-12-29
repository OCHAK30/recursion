/**
 * https://www.youtube.com/watch?v=kvRjNm4rVBE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=5
 * TC: O(2^n) -> exponential since, each time one function call is calling 2 more function calls.
 * SC: O(n) ->Recursion tree height
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n){
        if(n <= 1) return n;

        //multiple recursion calls
        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);

        return last + secondLast;
    }
}
