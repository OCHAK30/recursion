import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/problems/power-set4302/1
 * TC: O(2^n * n) -> n -> to insert into list
 * SC: O(2^n * n)
 * 🔄 Requires reattempting later
 */
public class PowerSet {
    public static void main(String[] args) {
        String s = "abc";
        AllPossibleStrings(s);
    }


    public static List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> list = new ArrayList<>();
        solve(0, s, list, "");
        Collections.sort(list);
        System.out.println(list.toString());
        return list;
    }

    public static void solve(int i, String s, List<String> list, String curr){
        //Base case
        if(i == s.length()){
            if(curr.length() != 0){
                list.add(curr);
            }
            return;
        }

        //Take
        //In String problems we use the curr String to add/remove characters not a list
        solve(i+1, s, list, curr + s.charAt(i));
        //Not Take
        //Strings are immutable so we don't remove anything as the original String is never changed
        solve(i+1, s, list, curr);
    }
}


