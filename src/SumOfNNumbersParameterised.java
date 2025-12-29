//https://www.youtube.com/watch?v=69ZCDFy-OUo&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=3
public class SumOfNNumbersParameterised {
    public static void main(String[] args) {
        int n = 3;
        sumOfNNumbers(n, 0);
    }

    public static void sumOfNNumbers(int i, int sum){
        if(i < 1){
            System.out.println(sum);
            return;
        }

        sumOfNNumbers(i-1, sum + i);
    }
}
