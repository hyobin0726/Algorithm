import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp= new long[n+1];
        dp[1] =0;

        if(n >= 2){
            dp[2] = 3;
            tile(n);
        }
        System.out.println(dp[n]);

    }
    static void tile(int x){
        for(int i=4; i<=x; i+=2){
            dp[i] = dp[i-2]*3;
            dp[i] += 2; //특이케이스
//            System.out.println(dp[i] + " " + i);
            int temp = i-4;
            if(i > 4) {
                for (int j = 2; j <= temp; j += 2) {
                    dp[i] += (dp[j] * 2); //앞뒤바꾼경우
                }
            }

        }
    }
}