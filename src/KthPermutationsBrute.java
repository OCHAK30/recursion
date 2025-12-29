import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 * https://www.youtube.com/watch?v=wT7gcXLYoao&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=21
 *
 * 1. First Approach
 * //generate all permutation for 1 to n
 * //store all permutation in some data structure
 * //return kth term from data structure
 *
 * //Example :- n=3 , k=4
 * //Generate permutations(LeetCode Qus. 46 :- Permutations) 1 to 3 i.e.
 * 123
 * 132
 * 213
 * 231
 * 312
 * 321
 * //k=4th term is 231
 * //our ans will be 231
 *
 * Refer solution - https://leetcode.com/problems/permutation-sequence/solutions/2777028/permutation-sequence-java-solution-1-bruteforce-approach-2-optimal-approach/
 *
 * T.C :- n!(for generating permutation) * n(for looping i=0 to arr.length) * n!logn(for sorting n! permutation)
 * SC: O(n) -> Stack space + O(n!) -> returning the ans
 * 🔄 Requires reattempting later
 */

public class KthPermutationsBrute {
    public static void main(String[] args) {
        int n = 3, k = 4;
        getPermutation(n, k);
    }

    public static String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        List<String> ans = new ArrayList<>();
        solve(0, arr, n, k, ans);

        Collections.sort(ans);
        System.out.println(ans.get(k-1));
        return ans.get(k-1);
    }

    public static void solve(int ind, int[] arr, int n, int k, List<String> ans){
        //Base case
        if(ind == arr.length){
            String str = "";
            for (int i = 0; i < arr.length; i++) {
               str = str + arr[i];
            }
            ans.add(str);
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            swap(i, ind , arr);
            solve(ind + 1, arr, n, k, ans);
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
