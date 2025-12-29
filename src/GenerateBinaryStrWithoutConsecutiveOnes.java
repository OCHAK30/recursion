import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=generate-binary-strings-without-consecutive-1s
 * TC: O(2^n)
 * SC: O(n)
 */
public class GenerateBinaryStrWithoutConsecutiveOnes {
    public static void main(String[] args) {
        int n = 4;
        List<String> list = new ArrayList<>();

        String curr = "";
        curr = "0";
        allBinaryStrings(curr, n, list);

        //Initialising first character to 1
        curr = "1";
        allBinaryStrings(curr, n, list);

        System.out.println(list.toString());
    }

    public static void allBinaryStrings(String curr, int n, List<String> list){
        //base case
        if(curr.length() == n){
            list.add(curr);
            return;
        }

        //If last character is 0, we can add 0 and 1 to the string
        if(curr.charAt(curr.length() - 1) == '0'){
            allBinaryStrings(curr + "0", n, list);
            allBinaryStrings(curr + "1", n, list);
        }else {
            //If last character is 1, we can add only 0's to the string
            allBinaryStrings(curr + "0", n, list);
        }
    }
}
