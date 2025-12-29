import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/permutations/description/
 * https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=15
 * TC: n! * n -> looping through array is O(n)
 * SC: O(n) -> Stack space + O(n!) -> returning the ans
 * 🔄 Requires reattempting later
 */

public class PermutationsBetter {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permute(arr);
    }

    //All the integers of arr are unique.
    public static List<List<Integer>> permute(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();

        solve(0, arr, ans);
        System.out.println(ans);
        return ans;
    }

    public static void solve(int ind, int[] arr, List<List<Integer>> ans){
        //Base case
        if(ind == arr.length){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            swap(i, ind , arr);
            solve(ind + 1, arr, ans);
            //re-swap it
            swap(i, ind, arr);
        }
    }

    public static void swap(int i, int ind, int[] arr){
        int temp = arr[i];
        arr[i] = arr[ind];
        arr[ind] = temp;
    }
}
