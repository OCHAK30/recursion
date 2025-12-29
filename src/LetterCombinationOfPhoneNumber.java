import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * https://www.youtube.com/watch?v=vgnhZzw-kfU
 *
 * Time complexity: O(3^n * n) or O(4^n * n); n -> to store in list
 * n is length of input string. Each digit has 3 or 4 letters. For example, if you get "23"(n) as input string, we will create 9 combinations which is O(3^2) = 9
 *
 * Space complexity: O(n)
 * n is length of input string. This is for recursive call stack.
 */
public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        letterCombinations(digits);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        HashMap<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        solve(0, digits, new StringBuilder(), ans, digitToLetters);

        System.out.println(ans);
        return ans;
    }

    public static void solve(int ind, String digits, StringBuilder sb, List<String> ans, HashMap<Character, String> digitToLetters){
        //Base case
        if(ind == digits.length()){
            ans.add(sb.toString());
            return;
        }

        //Input "23", digits.charAt(ind) -> digits.charAt(0) = 2
        char ch = digits.charAt(ind);
        //digitToLetters.get(ch) -> digitToLetters.get(2) -> "abc"
        String str = digitToLetters.get(ch);

        //we have to iterate through "abc"
        for (int i = 0; i < str.length(); i++) {
            //you take one letter at a time from str -> suppose "a"
            sb.append(str.charAt(i));
            //ind+1 -> points to -> 3 now in "23"
            solve(ind+1, digits, sb, ans, digitToLetters);
            //undo inserted String into sb
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
