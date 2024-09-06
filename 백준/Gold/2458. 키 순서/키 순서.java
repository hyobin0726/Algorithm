import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] adjmatrix, radjmatrix;
    static int ans;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ans =0;
        adjmatrix = new int[n+1][n+1];
        radjmatrix = new int[n+1][n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjmatrix[a][b] = 1;
            radjmatrix[b][a] = 1;

        }
        //자신보다 큰, 작은 학생 각각 탐색
        for(int i=1; i<=n; i++) {
            cnt = 0;
            dfs(i, adjmatrix, new boolean[n+1]);
            dfs(i, radjmatrix, new boolean[n+1]);
            if(cnt == n-1) ans++;



        }System.out.println( ans);
    }
    static void dfs(int cur , int[][] matrix , boolean[] visited) {
        visited[cur] = true;
        for(int i=1; i<=n ; i++) {
            if(!visited[i] && matrix[cur][i] != 0) {
                dfs(i, matrix, visited);
                cnt++;
            }
        }
    }

}
