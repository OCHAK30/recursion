import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=7xkPbffc6w8
 * https://leetcode.com/problems/generate-parentheses/description/
 * TC: O(2^2*n * 2*n)
 * SC: O(2n) -> depth of recursion tree
 */

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 2;
        List<String> list = new ArrayList<>();

        generateParenthesis("", list, n);

        System.out.println(list.toString());
    }

    public static void generateParenthesis(String curr, List<String> list, int n) {
        //base case
        if(curr.length() == 2 * n){
            if(isValid(curr)){
                list.add(curr);
            }
            return;
        }

        generateParenthesis(curr + "(", list, n);
        generateParenthesis(curr + ")",list, n);
    }

    public static boolean isValid(String curr){
        int sum = 0;

        for (int i = 0; i < curr.length(); i++) {

            if (curr.charAt(i) == '(')
                sum++;
            else
                sum--;

            //"( ) ) (" -> kisi bhi point pe sum -ve nahi hona chahiye
            if (sum < 0)
                return false;

        }
        return sum == 0; // sum has to be 0 for a valid parenthesis
    }
}
