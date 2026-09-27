import java.util.Arrays;

public class POTD {
    static int minOp = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        int x = 5;
        System.out.println(minOperations(nums,x));

    }

    public static int minOperations(int[] nums, int x) {
        minOp = Integer.MAX_VALUE;
        int i = 0, j = nums.length-1;
        int count = 0, temp = x;

        solve(nums, x, i, j, count);
        return minOp == Integer.MAX_VALUE ? -1 : minOp;
    }

    public static void solve(int[] nums, int x, int i, int j, int count){
        if(x == 0){
            minOp = Math.min(minOp, count);
            return;
        }

        if (i > j || x < 0) {
            return;
        }

        solve(nums, x - nums[i], i+1, j, count+1);
        solve(nums, x - nums[j], i,j-1, count+1);
    }
}
