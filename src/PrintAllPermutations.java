import java.util.*;

//TC: O(n! * n) -> n! for number of permutations and looping from {0-(n-1)} takes O(n)
//SC: O(n) for list + O(n) for map data structure
public class PrintAllPermutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        ans = permute(nums);
        System.out.println(ans);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        getPermutations(nums,ans, new ArrayList<>(), freq);
        return ans;
    }

    public static void getPermutations(int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] freq){
        //Base case
        if(nums.length == list.size()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!freq[i]){
                list.add(nums[i]);
                freq[i] = true;
                getPermutations(nums, ans, list, freq);
                list.remove(list.size()-1);
                freq[i] = false;
            }
        }
    }
}
