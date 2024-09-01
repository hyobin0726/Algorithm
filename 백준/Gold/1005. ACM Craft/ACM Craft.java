import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int k;
    static ArrayList<Integer>[] graph;
    static int[] time;
    static int[] indegree;
    static int w;
    static int[] result;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=0; tc<t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            time = new int[n+1];
            graph = new ArrayList[n+1];
            for(int i=1; i<=n; i++) {
                graph[i] = new ArrayList<>();
            }
            indegree = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i= 0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                indegree[b]++;
            }
            w = Integer.parseInt(br.readLine());

            for(int i=1; i<=n; i++) {
                if(indegree[i]==0) {
                    q.add(i);
                }
            }
            result = new int[n+1];
            for(int i=1; i<=n; i++) {
                result[i] = time[i];
            }
            while(!q.isEmpty()) {
                int temp = q.poll();
                for(int i : graph[temp]) {
                    result[i] = Math.max(result[i], result[temp]+time[i]);
                    indegree[i]--;
                    if(indegree[i]==0) {
                        q.add(i);
                    }
                }
            }
            System.out.println(result[w]);

        }
    }
}
