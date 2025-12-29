//Using two pointers
//https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=4

public class ReverseAnArrayTwoPointers {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int l = 0, r = arr.length - 1;
        reverseArr(l , r, arr);

        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public static void reverseArr(int l , int r, int[] arr){

        if(l >= r) return;

        //swap l with r and vice versa
        swap(l, r, arr);

        reverseArr(l+1, r-1, arr);
    }

    public static void swap(int l, int r, int[] arr){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
