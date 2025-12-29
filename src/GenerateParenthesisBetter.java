import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=7xkPbffc6w8
 * https://leetcode.com/problems/generate-parentheses/description/
 * TC: O(2^2*n)
 * SC: O(2n) -> depth of recursion tree
 */

public class GenerateParenthesisBetter {
    public static void main(String[] args) {
        int n = 2;
        List<String> list = new ArrayList<>();

        generateParenthesis("", list, n, 0, 0);

        System.out.println(list.toString());
    }

    public static void generateParenthesis(String curr, List<String> list, int n, int open, int close) {
        //base case
        if(curr.length() == 2 * n){
            list.add(curr);
            return;
        }

       if(open < n) generateParenthesis(curr + "(", list, n, open + 1, close);
       if(close < open) generateParenthesis(curr + ")", list, n, open, close + 1);

    }

}
