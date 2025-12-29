import java.util.Scanner;

public class PrintLinearlyfromNTo1Backtracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number ");
        int n = sc.nextInt();
        print(1, n);
    }

    public static void print(int i , int n){
        //Base condition
        if(i > n){
            return;
        }

        //Backtracking to print in linearly decreasing order, you cannot use (i-1, n)
        print(i+1, n);
        System.out.println(i);
    }
}
