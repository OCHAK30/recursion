import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/problems/better-string/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=better-string
 */
public class BetterString {
    public static void main(String[] args) {
        String s1 = "gfg";
        String s2 = "ggg";

        String ans = betterString(s1, s2);
        System.out.println(ans);
    }

    public static String betterString(String s1, String s2) {
        // Base case
        Set<String> seq1 = new HashSet<String>();
        Set<String> seq2 = new HashSet<String>();
        countSubSeq(0, s1, "", seq1);
        countSubSeq(0, s2, "", seq2);
        System.out.println(seq1.toString());
        System.out.println(seq2.toString());
        return seq1.size() >= seq2.size() ? s1 : s2;
    }

    public static void countSubSeq(int i, String s, String str, Set<String> set){
        if(i == s.length()) {
            //we are ignoring empty string
            if(str.length() != 0) {
                set.add(str);
            }
            return;
        }
        //Take
        countSubSeq(i + 1, s, str + s.charAt(i), set);
        //No-Take
        countSubSeq(i + 1, s, str, set);

    }
}
