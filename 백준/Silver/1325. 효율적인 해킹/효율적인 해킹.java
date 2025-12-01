import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);

        }

        int[] ans = new int[n+1];
        int max = 0;

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];

        for(int i =1; i<=n; i++){
            q.add(i);
            visited[i] = i;
            int cnt =0;

            while (!q.isEmpty()) {
                int tmp = q.poll();
                cnt++;
                for (int j = 0; j < list[tmp].size(); j++) {
                    if(visited[list[tmp].get(j)] != i) {
                        visited[list[tmp].get(j)]=i;
                        q.add(list[tmp].get(j));
                    }
                }
            }
            ans[i] = cnt;

        }

        for(int i=1; i<=n; i++){
            max = Math.max(max, ans[i]);
//            System.out.println(ans[i]);
        }
//        System.out.println(max);
        for(int i=1; i<=n; i++){
            if(max == ans[i]){
                System.out.print(i + " ");
            }
        }


    }

}