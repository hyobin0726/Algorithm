import java.io.*;
import java.util.*;
public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][31];
        dp[1][1] =1;
        pascal(n,k);
        System.out.println(dp[n][k]);
    }
    static void pascal(int x, int y){

        for(int i=2; i<=x; i++){
            for(int j=1; j<=i; j++){
                if(i==1 || i==j){
                    dp[i][j] = 1;
                }
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }
}
