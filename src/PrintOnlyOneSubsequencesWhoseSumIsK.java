/**
 * https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7
 * TC: O(2 ^ n) -> Every index has two possibilities O(2^n) .... Note: No extra × n here because we are not printing all subsequences, just stopping at one.
 * SC: O(n) -> recursive stack space
 */

import java.util.ArrayList;

public class PrintOnlyOneSubsequencesWhoseSumIsK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        ArrayList<Integer> list = new ArrayList<>();
        int k = 2;
        printAllSubSequence(0, arr, list, k, 0);
    }

    public static boolean printAllSubSequence(int i, int[] arr, ArrayList<Integer> list, int k, int sum){
        //Base condition, if 'i' reaches end of array length
        if(i == arr.length){
            //condition satisfied
            if(k == sum) {
                System.out.println(list.toString());
                return true;
            }
            //condition not satisfies
            return false;
        }

        //add current index value to the list
        list.add(arr[i]);
        //add it to sum
        sum += arr[i];
        //take condition
        if(printAllSubSequence(i + 1, arr, list, k, sum) == true) return true;
        //remove the last added element to the list
        list.remove(list.size() - 1);
        //remove it from sum
        sum -= arr[i];
        //not take condition
        if(printAllSubSequence(i+1, arr, list, k, sum) == true) return true;

        return false;
    }
}
