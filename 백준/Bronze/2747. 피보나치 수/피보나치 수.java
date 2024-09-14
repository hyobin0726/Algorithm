import java.io.*;
import java.util.*;
public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[46];
        dp[0] = 0;
        dp[1] =1;
        int temp = Integer.parseInt(br.readLine());
        fibo(temp);
        System.out.println(dp[temp]);

    }
    static void fibo(int x){
        for(int i=2; i<=x; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

    }
}
