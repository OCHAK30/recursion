/**
 * https://www.youtube.com/watch?v=AxNNVECce8c&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=6
 * TC: O(2 ^ n) * n -> Every index has two possibilities O(2^n) and we are print each subsequence as well so, O(n).
 * SC: O(n) -> recursive stack space
 */

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllSubsequences {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        ArrayList<Integer> list = new ArrayList<>();

        printAllSubSequence(0, arr, list);
    }

    public static void printAllSubSequence(int i, int[] arr, ArrayList<Integer> list){
        //Base condition, if 'i' reaches end of array length
        if(i == arr.length){
            System.out.println(list.toString());
            return;
        }

        //add current index value to the list
        list.add(arr[i]);
        //take condition
        printAllSubSequence(i+1, arr, list);
        //remove the last added element to the list
        list.remove(list.size() - 1);
        //not take condition
        printAllSubSequence(i+1, arr, list);
    }
}
