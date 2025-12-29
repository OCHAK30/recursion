public class POW {
    static long MOD = 1000000007;
    public static void main(String[] args) {
        double x = 2;
        long n = 3;

        double ans = pow(x, (long) n);
        System.out.println(ans);
    }

    public static double pow(double x, long n){
        if(n == 0) return 1;

        if(n < 0){
            return pow(1/x, -n);
        }

        if(n % 2 == 0){
           return pow(x * x, n/2);
        } else {
            return (x * pow(x * x, (n-1)/2));
        }
    }
}
