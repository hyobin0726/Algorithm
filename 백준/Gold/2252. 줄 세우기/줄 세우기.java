import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        indegree = new int[n+1];
        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;

        }
        for(int i=1; i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");
            for(int i : graph[temp]){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
    }

}
