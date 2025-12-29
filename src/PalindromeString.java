/**
 * https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=4
 * TC: O(n/2)
 * SC: O(n/2)
 */
public class PalindromeString {
    public static void main(String[] args) {
        String s = "madam";
        int n = s.length();
        boolean flag = palindrome(0, s, n);
        if(flag == true) System.out.println("Palindrome");
        else System.out.println("Not Palindrome");
    }

    public static boolean palindrome(int i , String s, int n){
        if(i >= n/2) return true;

        if(s.charAt(i) != s.charAt(n - i - 1)) return false;

        return palindrome(i+1, s, n);
    }
}
