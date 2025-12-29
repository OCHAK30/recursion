import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> l = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        findCombinations(0, candidates, target, ans, list);

        System.out.println(ans.toString());
        return ans;
    }

    public static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> list){
        //Base case
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[ind] <= target) {
            //insert into list
            list.add(arr[ind]);
            //pick
            findCombinations(ind, arr, target - arr[ind], ans, list);

            //remove from list before calling next element
            list.remove(list.size() - 1);
        }
        findCombinations(ind +1, arr, target, ans, list);

    }
}
