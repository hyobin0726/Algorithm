import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int[] ans;
    static boolean[] visited;
    static int cnt=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m =Integer.parseInt(st.nextToken());
        ans = new int[n+1];
        visited= new boolean[n+1];
        for(int i=1; i<n+1; i++){
            ans[i] = -1;
        }
        List<Integer>[] link = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            link[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            link[x].add(y);
            link[y].add(x);

        }

        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        ans[a] = 0;

        while (!q.isEmpty()){
            int t = q.poll();
            visited[t] = true;
            if(t==b) {
                break;
            }
            for(int i=0; i <link[t].size(); i++){
                if(!visited[link[t].get(i)]) {
                    q.add(link[t].get(i));
                    ans[link[t].get(i)] = ans[t] + 1;
                }
            }

        }

        System.out.println(ans[b]);

    }
}