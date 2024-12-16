import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp= new int[n+1];
        dp[1]= 1;
        if(n>1) {
            dp[2] = 3;
        }
        tile(n);
        System.out.println(dp[n]);
    }
    static void tile(int x){
        for(int i=3; i<=x; i++){
            dp[i] = (dp[i-1] + dp[i-2]*2) %10007;
        }
    }
}