import java.util.ArrayList;
import java.util.Collections;
/**
 * https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
 * TC: O(2^n + (2^n) log(2^n))
 * SC: O(2^n)
 */

public class SubSetSumI {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> sumList = new ArrayList<>();
        subSet(0,arr,list, sumList);

        Collections.sort(sumList);
        System.out.println(sumList.toString());
    }

    public static void subSet(int i, int[] arr, ArrayList<Integer> list, ArrayList<Integer> sumList) {
        // code here
        if(i == arr.length){
            int sum = 0;
            for(int a : list){
                sum += a;
            }
            sumList.add(sum);
            return;
        }

        list.add(arr[i]);
        subSet(i+1, arr, list, sumList);

        list.remove(list.size() - 1);
        subSet(i+1, arr, list, sumList);
    }

}
