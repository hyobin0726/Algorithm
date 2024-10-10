import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] cost = new int[n+1][n+1];
        StringTokenizer st;
        for(int i=1;i<=n;i++){
            for(int j=1; j<=n; j++){
                if(i == j){cost[i][j] =0;}
               else {cost[i][j] = 10000001;}
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[s][e] = Math.min(cost[s][e], c);
        }


        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(cost[i][j] >0) {
                        cost[i][j] = Math.min(cost[i][k] + cost[k][j], cost[i][j]);
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1; j<=n; j++){
                if(cost[i][j] == 10000001){
                    System.out.print(0 + " ");
                }
                else {System.out.print(cost[i][j] + " ");}
            }
            System.out.println();
        }
    }
}