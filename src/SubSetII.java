import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
 * TC: O(2^n + (2^n) log(2^n))
 * SC: O(2^n)
 */

public class SubSetII {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3};
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        subSet(0,arr,list, hs);

        // Convert HashSet to List
        List<ArrayList<Integer>> ans = new ArrayList<>(hs);

        System.out.println(ans.toString());
    }

    public static void subSet(int i, int[] arr, ArrayList<Integer> list, HashSet<ArrayList<Integer>> hs) {
        // code here
        if(i == arr.length){
            hs.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);
        subSet(i+1, arr, list, hs);

        list.remove(list.size() - 1);
        subSet(i+1, arr, list, hs);
    }

}
