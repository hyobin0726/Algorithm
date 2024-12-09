import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] degree;
    static int n,m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        degree = new int[n+1];
        graph = new List[n+1];
        for(int i=0; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            degree[b]++;

        }

        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            if(degree[i] ==0){
                pq.add(i);
                degree[i]--;
            }
        }

        while (!pq.isEmpty()){
            int temp = pq.poll();
            sb.append(temp + " ");

            for(int i=0; i<graph[temp].size(); i++){
                int child = graph[temp].get(i);
                degree[child]--;
                if(degree[child] ==0){
                    pq.add(child);
                }
            }
        }
        System.out.println(sb);
     }
}