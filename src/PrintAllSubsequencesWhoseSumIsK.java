/**
 * https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7
 * TC: O(2 ^ n) * n -> Every index has two possibilities O(2^n) and we are print each subsequence as well so, O(n).
 * SC: O(n) -> recursive stack space
 */

import java.util.ArrayList;

public class PrintAllSubsequencesWhoseSumIsK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        ArrayList<Integer> list = new ArrayList<>();
        int k = 2;
        printAllSubSequence(0, arr, list, k, 0);
    }

    public static void printAllSubSequence(int i, int[] arr, ArrayList<Integer> list, int k, int sum){
        //Base condition, if 'i' reaches end of array length
        if(i == arr.length){
            if(k == sum) {
                System.out.println(list.toString());
            }
            return;
        }

        //add current index value to the list
        list.add(arr[i]);
        //add it to sum
        sum += arr[i];
        //take condition
        printAllSubSequence(i+1, arr, list, k, sum);
        //remove the last added element to the list
        list.remove(list.size() - 1);
        //remove it from sum
        sum -= arr[i];
        //not take condition
        printAllSubSequence(i+1, arr, list, k, sum);
    }
}
