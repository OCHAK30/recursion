public class ReverseAString {
    public static void main(String[] args) {
        String s = "abc";
        reverseString(0, s);
    }

    public static void reverseString(int i, String s){

        if(i >= s.length()){
            return;
        }

        reverseString(i+1, s);
        System.out.print(s.charAt(i));
    }
}
