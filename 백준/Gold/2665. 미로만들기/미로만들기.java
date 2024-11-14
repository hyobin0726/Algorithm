import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[][] map;
    static int[][] min;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static class node implements Comparable<node>{
        int x,y,cost;

        public node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        min= new int[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = str.charAt(j)-'0';
                if (map[i][j] == 0) {
                    map[i][j]=1;
                }else {
                    map[i][j]=0;
                }
                min[i][j] =Integer.MAX_VALUE;
            }
        }
        min[0][0]=0;
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(0,0,map[0][0]));
        while (!pq.isEmpty()){
            node temp = pq.poll();
            int tx = temp.x;
            int ty = temp.y;
            int tcost = temp.cost;
            if(ty ==n && ty ==n){
                return;
            }

            for(int i=0; i<4; i++){
                int nx = tx +dx[i];
                int ny = ty + dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<n){
                    if(min[nx][ny] > tcost + map[nx][ny]){
                        min[nx][ny] = tcost + map[nx][ny];
                        pq.add(new node (nx,ny,min[nx][ny]));
                    }
                }
            }
        }
        System.out.println(min[n-1][n-1]);

    }
}