import java.io.IOException;
import java.util.*;
import java.io.*;
public class Main {

    static int n;
    static int[] population, area;
    static ArrayList<Integer>[] list;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        population = new int[n + 1];
        list = new ArrayList[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        area = new int[n + 1];
        dfs(1);

        if(min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
    }

    public static void dfs(int k) {
        if(k == n + 1) {
            int area1 = 0;
            int area2 = 0;
            for(int i = 1; i <= n; i++) {
                if(area[i] == 1) area1 += population[i];
                else area2 += population[i];
            }

            visited = new boolean [n + 1];
            int link = 0;
            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    bfs(i, area[i]);
                    link++;
                }
            }

            if(link == 2) min = Math.min(min, Math.abs(area1 - area2));

            return;
        }

        area[k] = 1;
        dfs(k + 1);

        area[k] = 2;
        dfs(k + 1);
    }

    public static void bfs(int idx, int areaNum) {
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.offer(idx);

        while(!q.isEmpty()) {
            int current = q.poll();

            for(int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                if(area[next] == areaNum && !visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
