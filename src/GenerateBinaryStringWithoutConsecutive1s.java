import java.util.ArrayList;

///https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
public class GenerateBinaryStringWithoutConsecutive1s {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(binstr(n));
    }

    public static ArrayList<String> binstr(int n){
        ArrayList<String> list = new ArrayList<>();
        getBinStr("", 0, list, n);
        return list;
    }

    public static void getBinStr(String str , int last, ArrayList<String> list, int n){
        if(str.length() == n){
            list.add(str);
            return;
        }

        getBinStr(str + "0", 0, list, n);
        if(last == 0){
            getBinStr(str + "1", 1, list, n);
        }
    }
}
