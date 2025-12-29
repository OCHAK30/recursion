import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
 * No need to use list
 * TC: O(2^n + (2^n) log(2^n))
 * SC: O(2^n)
 */
public class SubSetSumI_AnotherApproach {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        ArrayList<Integer> sumList = new ArrayList<>();
        subSet(0,arr, sumList, 0);

        Collections.sort(sumList);
        System.out.println(sumList.toString());
    }

    public static void subSet(int i, int[] arr, ArrayList<Integer> sumList, int sum) {
        // code here
        if(i == arr.length){
            sumList.add(sum);
            return;
        }

        //pick the element
        sum += arr[i];
        subSet(i+1, arr, sumList, sum);

        //do not pick the element
        sum -= arr[i];
        subSet(i+1, arr, sumList, sum);
    }

}
