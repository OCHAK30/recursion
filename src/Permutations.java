import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 * https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=15
 *
 * TC: n! * n -> looping through array is O(n)
 * SC: O(n) -> list + O(n) -> freq[] + O(n) recursive stack space + O(n!) -> returning ans
 * 🔄 Requires reattempting later
 */

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permute(arr);
    }

    //All the integers of arr are unique.
    public static List<List<Integer>> permute(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];

        solve(arr, list, ans, freq);
        System.out.println(ans);
        return ans;
    }

    public static void solve(int[] arr, List<Integer> list, List<List<Integer>> ans, boolean[] freq){
        //Base case
        if(list.size() == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(freq[i] == false){
                freq[i] = true;
                list.add(arr[i]);

                solve(arr, list, ans, freq);

                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }
}
