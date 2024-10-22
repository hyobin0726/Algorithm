import java.io.*;
import java.util.*;

public class Main {
    static int v,e;
    static int[][] node;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v= Integer.parseInt(st.nextToken());
        e =Integer.parseInt(st.nextToken());

        node = new int[v+1][v+1];

        for(int i=0; i<=v; i++){
            for(int j=0; j<=v; j++){
                if(i==j) {
                    node[i][j] = 0;
                }
                else {
                    node[i][j] = 10000001;
                }
            }
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int s =Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            node[s][e] = Math.min(node[s][e], d);
        }

        for(int k=1; k<=v; k++){
            for(int i=1; i<=v; i++){
                for(int j=1; j<=v;j++){
                    node[i][j] = Math.min(node[i][j], node[i][k] + node[k][j]);
                }
            }
        }
        for(int i=1; i<=v; i++){
            for(int j =1; j<=v; j++){
                if(node[i][j] ==10000001 ){
                    node[i][j] =0;
                }
            }
        }
        int[] result = new int[v];
        for(int i=0; i<v;i++){
            result[i] = 10000001;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++) {
                if(node[i][j] ==0 || node[j][i] ==0) continue;
                result[i-1] = Math.min (node[i][j] + node[j][i], result[i-1]);
                if(ans>result[i-1]){
                    ans= result[i-1];
                }
            }
        }
    if(ans == Integer.MAX_VALUE){
        System.out.println(-1);
    }else {
        System.out.println(ans);
    }


    }
}