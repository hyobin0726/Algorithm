import java.io.*;
import java.util.*;

public class Main {
    static int n ;
    static int m;
    static int[] arr;
//    static boolean[] visited;
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
//        visited = new boolean[n+1];
        dfs(0);

        System.out.println(sb);

    }
    static void dfs(int depth){
        if (depth== m){

            for (int a : arr){
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i<n; i++){
            arr[depth]=i+1;
            dfs(depth+1);

        }

    }

}
