import java.util.Scanner;

public class printNTo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N: ");
        int n = sc.nextInt();
        print(n, n);
    }

    public static void print(int i , int n){
        //Base condition
        if(i < 1){
            return;
        }
        System.out.println(i);
        print(i-1, n);
    }
}
