import java.util.ArrayList;
import java.util.Arrays;

public class GenerateAllBinaryStrings {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(binstr(n));
    }

    public static ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> list = new ArrayList<>();
        getBinStr("", list, n);
        return list;
    }

    public static void getBinStr(String str, ArrayList<String> list, int n){
        if(str.length() == n){
            list.add(str);
            return;
        }

        getBinStr(str + "0", list, n);
        getBinStr(str + "1", list, n);
    }
}
