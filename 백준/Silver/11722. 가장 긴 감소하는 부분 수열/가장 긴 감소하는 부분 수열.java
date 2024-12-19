import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp(n);
    }
    static void dp(int x){
        for (int i = 1; i <= x; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(arr[i] < arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}