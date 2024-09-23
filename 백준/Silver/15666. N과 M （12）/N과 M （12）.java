import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int[] num;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        num = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0,0,new int[m]);

    }
    static void dfs( int idx, int cnt, int[] arr){
        if(cnt == m){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<m; i++){
                sb.append(arr[i]+" ");
            }
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                System.out.println(sb);
            }
            return;
        }
        for(int i=idx; i<n; i++){
//            if(visited[i]) continue;
//            visited[i] = true;
            arr[cnt] = num[i];
            dfs(i, cnt+1, arr);
//            visited[i] = false;
        }
    }
}
