import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        result = new int[n+1];
        for(int i=0; i<= n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=1;i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);

        }
        dfs(1);
        for(int i=2; i<=n; i++){
            System.out.println(result[i]);
        }
    }
    static void dfs(int x){
        visited[x] = true;
        for(int i=0; i < arr[x].size(); i++){
            if(!visited[arr[x].get(i)]){
                result[arr[x].get(i)]=x;
                dfs(arr[x].get(i));
            }
        }
    }

}
