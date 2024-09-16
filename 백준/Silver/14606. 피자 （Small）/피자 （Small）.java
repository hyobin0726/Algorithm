import java.io.*;
public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[11];
        pizza(n);
        System.out.println(dp[n]);
    }
    static void pizza(int x){
        for(int i=1; i<=x; i++){
            dp[i] = (i-1) + dp[i-1];
        }
    }
}
