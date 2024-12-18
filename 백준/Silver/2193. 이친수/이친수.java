import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        dp[1]= 1;
        if(n>= 2){
            dp(n);
        }
        System.out.println(dp[n]);
    }
    static void dp(int x){
        for(int i=2; i<=x; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
}