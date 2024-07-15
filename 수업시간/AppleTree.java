import java.util.Scanner;
import java.util.*;
import java.io.*;

public class AppleTree {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];


        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j< n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }


        int answer = Integer.MIN_VALUE;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int nx=0;
        int ny=0;


        for(int i=0; i<n; i++) {
            for (int j = 0; j< n; j++) {
                int sum=arr[i][j];
                for (int k=0; k <4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];
                    if (0<=nx && nx<n  && 0<=ny && ny<n) {
                        sum += arr[nx][ny];
                    }
                }
                if (answer < sum) {
                    answer= sum;
                }

            }
        }
        System.out.println(answer);



    }

}