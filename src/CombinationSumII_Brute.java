import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * TC: O(2^t * k * log n) -> putting list into set which takes O(1) in java; log n -> sorting the array
 * SC: k * x
 */
public class CombinationSumII_Brute {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(candidates);
        combinationSumII(candidates, target);
    }

    public static List<List<Integer>> combinationSumII(int[] candidates, int target){
        //Using HashSet will make sure that duplicate combinations are not stored.
        HashSet<List<Integer>> hs = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        findCombinations(0, candidates, target, hs, list);

        //HashSet can be converted to list of list
        List<List<Integer>> ans = new ArrayList<>(hs);

        System.out.println(ans.toString());
        return ans;
    }

    public static void findCombinations(int ind, int[] arr, int target, HashSet<List<Integer>> hs, List<Integer> list) {
        //Base case
        if(ind == arr.length){
            if(target == 0){
                hs.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[ind] <= target){
           list.add(arr[ind]);
           //ind + 1 -> because we cannot take same index twice
           findCombinations(ind + 1, arr, target - arr[ind], hs, list);
           //remove last element from list before calling next recursion
           list.remove(list.size() - 1);
        }
        findCombinations(ind + 1, arr, target, hs, list);
    }
}
