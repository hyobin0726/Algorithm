import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static boolean[][] map;
    static int ans;
    static int width;
    static int temp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        width = n *m;
        map = new boolean[n][m];
        ans = (int) Math.pow(2,n*m);
        temp = 0;
        dfs( 0);
        System.out.println(ans);

    }
    static void dfs(  int idx ){
        if (idx == width){
            if(!check(map)){
                ans--;
            }
            return;
        }
        int i = idx / m;
        int j = idx % m;
        map[i][j] = true;
        dfs(idx + 1);

        map[i][j] = false;
        dfs(idx + 1);

        }
        static boolean check(boolean[][] map){
            for(int i=0;i<n-1; i++){
                for(int j=0; j<m-1; j++){
                    if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]){
                        return false;
                    }
                }
            }
            return true;

    }
}