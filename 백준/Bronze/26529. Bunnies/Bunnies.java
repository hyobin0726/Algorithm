import java.io.*;
import java.util.*;
public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[46];
        dp[0]=1;
        dp[1] =1;
        int n = Integer.parseInt(br.readLine());
        for(int i =0; i<n; i++){
            int temp = Integer.parseInt(br.readLine());
            fibo(temp);
            System.out.println(dp[temp]);
        }

    }
    static int fibo(int x){
        if(dp[x] ==0){
            dp[x] = fibo(x-1) + fibo(x-2);
        }
        return dp[x];

    }
}
