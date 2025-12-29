import java.util.Scanner;

public class PrintLinearlyfrom1ToNBacktracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number ");
        int n = sc.nextInt();
        print(n, n);
    }

    public static void print(int i , int n){
        //Base condition
        if(i < 1){
            return;
        }

        //Backtracking to print in linearly increasing order, you cannot use (i+1, n)
        print(i-1, n);
        System.out.println(i);
    }
}
