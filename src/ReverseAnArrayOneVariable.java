//Using two pointers
/**
 * https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=4
 *  * TC: O(n/2)
 *  * SC: O(n/2)
 */
public class ReverseAnArrayOneVariable {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        reverseArr(0, arr, n);

        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public static void reverseArr(int i , int[] arr, int n){

        //If 'i' is greater than or equal to half of the arr, that means i has crossed middle of arr
        if(i >= n/2) return;

        //swap i with (n - i - 1) and vice versa
        swap(i, (n - i - 1), arr);

        reverseArr(i+1, arr, n);
    }

    public static void swap(int l, int r, int[] arr){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
