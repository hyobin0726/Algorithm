
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test < t+1; test++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[] score = new int[n + 1];
            int[] kcal = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());

            }
            int[][] dp = new int[n + 1][l + 1];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j <= l; j++) {
                    if (j < kcal[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - kcal[i]] + score[i], dp[i - 1][j]);

                    }
                }
            }
            System.out.println("#" + test + " "+  dp[n][l]);
        }
    }
}
