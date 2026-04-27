import java.util.ArrayList;
import java.util.List;

//TC: O(n! * n) -> n! for number of permutations and looping from {0-(n-1)} takes O(n)
//SC: O(n) recursion depth[auxiliary space] and O(n!) for storing the value in ans; NO EXTRA SPACE
public class PrintAllPermutationsOptimal {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        ans = permute(nums);
        System.out.println(ans);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPermutations(0, nums, ans);
        return ans;
    }

    public static void getPermutations(int ind, int[] nums, List<List<Integer>> ans){
        //Base case
        if(ind == nums.length){
            List<Integer> list = new ArrayList<>();
            //put nums data into list
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }

        //loop from ind -> n-1 ---- IMP
        for (int i = ind; i < nums.length; i++) {
            //swap
            swap(i, ind, nums);
            //call recursion
            getPermutations(ind+1,nums,ans);
            //reverse swap
            swap(i, ind, nums);
        }
    }

    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
