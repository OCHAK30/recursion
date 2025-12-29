/**
 * https://leetcode.com/problems/count-good-numbers/
 * TC: O(log n)
 * SC: O(log n)
 */
public class CountGoodNumbers {
    static long MOD = 1000000007;
    public static void main(String[] args) {
        int n = 50;
        int ans = countGoodNumbers(n);
        System.out.println(ans);
    }

    public static int countGoodNumbers(long n) {
        //calculating the number of even and odd positions in the given number
        long even = (n+1)/2;
        long odd = n/2;
        //even: 0,2,4,6,8 -> 5 options
        //prime: 2,3,5,7
        //so, basically 5^even * 4^odd
        return (int) (pow(5, even) * pow(4, odd) % MOD);
    }

    public static long pow(long x, long n){
        //Base case
        if(n == 0) return 1;

        long half = pow(x, n/2);

        if(n % 2 == 0){
            return (half * half) % MOD;
        } else {
            //if n is odd length then we will have extra even position 'x'
            return (x * half * half) % MOD;
        }
    }
}

