/**
  https://www.youtube.com/watch?v=69ZCDFy-OUo&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=3
  TC: O(n)
  SC: O(n)
*/
public class FactorialOfNNumbers {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(factorialNNumbers(n));
    }

    public static int factorialNNumbers(int n){
        if(n == 1) return 1;

        return n * factorialNNumbers(n-1);
    }
}
