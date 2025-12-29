import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * TC: O(2^t * k * log n) -> putting list into set which takes O(1) in java; log n -> sorting the array
 * SC: k * x
 */
public class CombinationSumII_Optimal {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        //list of combinations has to be in sorted order
        Arrays.sort(candidates);
        combinationSumII(candidates, target);
    }

    public static List<List<Integer>> combinationSumII(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        findCombinations(0, candidates, target, ans, list);
        System.out.println(ans.toString());
        return ans;
    }

    public static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> list) {
        //Base case
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[ind] <= target){
           list.add(arr[ind]);
           //ind + 1 -> because we cannot take same index twice
           findCombinations(ind + 1, arr, target - arr[ind], ans, list);
           //remove last element from list before calling next recursion
           list.remove(list.size() - 1);
        }
        while(ind + 1 < arr.length && arr[ind + 1] == arr[ind]){
            ind++;
        }
        findCombinations(ind + 1, arr, target, ans, list);
    }
}
