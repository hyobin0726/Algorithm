import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] sing = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            sing[i] = new ArrayList<>();
        }
        int[] degree = new int[n+1];
        for (int i=0; i<m; i++){
            st =new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            for(int t=0;t<temp-1;t++){
                int b = Integer.parseInt(st.nextToken());
                sing[a].add(b);
                degree[b] ++;
                a=b;

            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(degree[i] ==0){
                q.add(i);
                degree[i] --;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()){
            int temp = q.poll();
            result.add(temp);
            for(int i=0; i<sing[temp].size(); i++){
                degree[sing[temp].get(i)] --;
                if(degree[sing[temp].get(i)] ==0){
                    q.add(sing[temp].get(i));
                }
            }

        }
        if(result.size() ==n) {
            for(int i=0; i<n; i++){
                System.out.println(result.get(i));
            }
        }else {
            System.out.println(0);
        }
    }
}