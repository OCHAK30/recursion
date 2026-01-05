/**
 * https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7
 * TC: O(2 ^ n) -> Every index has two possibilities O(2^n)
 * SC: O(n) -> recursive stack space
 */

public class CountAllSubsequencesWhoseSumIsK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int k = 2;
        int count = countAllSubSequence(0, arr, k, 0);
        System.out.println(count);
    }

    /** we don't take the list in this problem */
    public static int countAllSubSequence(int i, int[] arr, int k, int sum){
        //Base condition, if 'i' reaches end of array length
        if(i == arr.length){
            //condition satisfied
            if(k == sum) {
                return 1;
            }
            //condition not satisfied
            return 0;
        }

        //add it to sum
        sum += arr[i];
        //take condition
        int l = countAllSubSequence(i+1, arr, k, sum);

        //remove it from sum
        sum -= arr[i];
        //not take condition
        int r = countAllSubSequence(i+1, arr, k, sum);

        return l+r;
    }
}
