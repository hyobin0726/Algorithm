import java.io.*;
import java.util.*;
public class Main {
    static int[] dp;
    static int cnt1;
    static int cnt2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[41];
        dp[1] = 1;
        dp[2] =1;
        cnt1=0;
        cnt2 =0;
        int temp = Integer.parseInt(br.readLine());
        fibore(temp);
        fibo(temp);

        System.out.println(cnt1 + " " + cnt2);

    }
    static void fibo(int x){
        for(int i=3; i<=x; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            cnt2++;
        }
    }
    static int fibore(int x){
        if(x==1 || x==2) {
            cnt1++;
            return 1;
        }
        dp[x] = fibore(x-1) + fibore(x-2);
        return dp[x];
    }
}
