import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    static int[] dp2;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        dp2 = new int[n+1];
        max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp(n);
        dp2(n);
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i] + dp2[i] - 1);
        }
        System.out.println(max);
    }
    static void dp(int x){
        for (int i = 1; i <= x; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                if(arr[i] >arr[j] && dp[i] < dp[j] + 1){

                    dp[i] = dp[j] + 1;
                }
            }
        }
    }
    static void dp2(int x){
        for (int i = n; i > 0; i--) {
            dp2[i] = 1;
            for (int j = n; j >= i; j--) {
                if(arr[i]  > arr[j] && dp2[i] < dp2[j] + 1){
                    dp2[i] = dp2[j] + 1;
                }
            }
        }
    }
}