import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
 * TC: O(2^n * n)
 * SC: O(2^n) * O(n)
 * Auxiliary Space: O(n)
 */

public class SubSetII_Optimal {
    public static void main(String[] args) {
        int[] arr = {4,4,4,1,4};
        //sorting the array to ignore same combination subsets
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subSet(0,arr,list, ans);

        System.out.println(ans.toString());
    }

    public static void subSet(int i, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        // code here
        if(i == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);
        subSet(i+1, arr, list, ans);
        list.remove(list.size() - 1);

        while(i+1 < arr.length && arr[i+1] == arr[i]){
            i++;
        }
        subSet(i+1, arr, list, ans);
    }

}
