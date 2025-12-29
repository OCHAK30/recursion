//https://www.youtube.com/watch?v=69ZCDFy-OUo&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=3
public class SumOfNNumbersFunctional {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(sumOfNNumbers(n));
    }

    public static int sumOfNNumbers(int n){
        if(n == 0){
            return 0;
        }
        return n + sumOfNNumbers(n - 1);
    }
}
