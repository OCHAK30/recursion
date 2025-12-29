import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 * TC: n! * n -> looping through array is O(n)
 * Iterating over each subset: O(M)
 * Copying each subset into the new list: O(N)
 * Combined: O(M * N)
 *
 * SC: O(n) -> Stack space + O(n!) -> returning the hs
 * 🔄 Requires reattempting later
 */

public class PermutationsII {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        permute(arr);
    }

    //Integers of arr might be duplicate.
    public static List<List<Integer>> permute(int[] arr){
        HashSet<List<Integer>> hs = new HashSet<>();

        solve(0, arr, hs);

        //HashSet can be converted to list of lists
        List<List<Integer>> ans = new ArrayList<>(hs);
        System.out.println(ans);
        return ans;
    }

    public static void solve(int ind, int[] arr, HashSet<List<Integer>> hs){
        //Base case
        if(ind == arr.length){
            List<Integer> list = new ArrayList<>();
            //Iterate through the array to store it in list
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            hs.add(new ArrayList<>(list));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            swap(i, ind , arr);
            solve(ind + 1, arr, hs);
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
