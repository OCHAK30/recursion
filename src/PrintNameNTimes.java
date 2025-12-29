import java.util.Scanner;

/** RECURSION TREE
     f(1,3)
       /
   f(2,3)
     /
  f(3,3)
   /
f(4,3)
*/
//TC: O(n), SC: O(n) -> stack space
public class PrintNameNTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of times you wanna print your name ");
        int n = sc.nextInt();
        print(1, n);
    }

    public static void print(int i , int n){
        //Base condition
        if(i > n){
            return;
        }
        System.out.println("Oendrila");
        print(i+1, n);
    }
}
