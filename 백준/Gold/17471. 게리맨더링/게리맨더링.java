import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] people;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean[] combi;
    static int ans= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        people = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++){
                int temp = Integer.parseInt(st.nextToken());
                list[i].add(temp);
            }
        }
        combi = new boolean[n+1];
        dfs(1, combi, 1);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }
    }
    static void dfs(int idx, boolean[] combi, int depth){
        if(idx == n+1){
            visited = new boolean[n+1];
            int link = 0;
            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    bfs(i,combi[i] );
                    link++;
                }
            }
            if(link ==2){
                int a = 0;
                int b=0;
                for(int i=1; i<=n;i++){
                    if(combi[i]){
                        a += people[i];
                    }else {
                        b+= people[i];
                    }
                }
                ans = Math.min(ans, Math.abs(a-b));
            }
//            System.out.println(Arrays.toString(combi));
            return;
        }
        for(int i=depth; i<=n;i++){
            combi[i] = true;
            dfs(idx+1, combi, i+1);
            combi[i] = false;
            dfs(idx+1, combi, i+1);
        }
    }
    static void bfs(int s, boolean area){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()){
            int temp = q.poll();
            for(int i=0; i<list[temp].size(); i++){
                int next = list[temp].get(i);
                if(!visited[next] & combi[next]== area){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

}