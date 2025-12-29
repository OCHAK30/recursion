/**
 * https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1
 * TC: O(2^n)
 * SC: O(n)
 */
public class TOH {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(towerOfHanoi(n, 1,2,3));
    }

    public static int towerOfHanoi(int n, int from, int to, int aux) {
        // Base case
        if(n == 0) return 0;
        if(n == 1){
            System.out.println("Moving disk " +n+ " from " +from + " to " +to);
            return 1;
        }

        int count = 0;
        //sending n-1 disks from rod -> aux rod; helper = to rod
        count = towerOfHanoi(n-1, from, aux, to);

        //moving the nth rod from rod -> to rod; no helper needed
        System.out.println("Moving disk " +n+ " from " +from + " to " +to);
        count++;

        //sending n-1 disks aux rod -> to rod; helper = from rod
        count += towerOfHanoi(n-1, aux, to, from);

        return count;
    }
}
