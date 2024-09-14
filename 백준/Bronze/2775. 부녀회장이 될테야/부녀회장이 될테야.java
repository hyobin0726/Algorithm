import java.io.*;
import java.util.*;
public class Main {
    static int[][] dp;
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            dp = new int[k+1][15];
            ap(k,n);
            System.out.println(dp[k][n]);
        }
    }
    static void ap(int x, int y){
        for(int i=0; i<15; i++){
            dp[0][i] = i;
        }
        for(int i=1; i<=x;i++){
            for(int j=1; j<=y; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }


    }

}
