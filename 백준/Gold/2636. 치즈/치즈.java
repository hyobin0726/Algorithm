import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static List<int[]> point;
    static int sum;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        map=new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if( j==m-1 || j==0  || i==0 || i==n-1){
                    map[i][j]=-1;
                    visited[i][j] = true;
                }
            }
        }

        cnt =0;
        sum=0;
        boolean istrue = false;
        while (!istrue) {
            istrue = true;
            cnt++;
            point = new LinkedList<>();
            for(int i=0;i<n;i++){
                for(int j=0; j<m;j++){
                    if(map[i][j] ==0 && !visited[i][j]){
                        for(int d =0;d<4; d++){
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if(0<=nx && 0<=ny && nx<n && ny< m && map[nx][ny]==-1){
                                bfs(i,j);
                                break;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (0 <= nx && 0 <= ny && nx < n && ny < m && map[nx][ny] == -1) {
                                istrue = false;
                                point.add(new int[] {i,j});
                                break;
                            }
                        }
                    }
                }
            }

            fuze(point);
            if(point.size()>0){
                sum = point.size();
            }
//            System.out.println(point.size());
        }

        System.out.println(cnt-1);
        System.out.println(sum);
    }
    static void bfs(int x, int y ){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        visited[x][y] = true;
        map[x][y] = -1;
        while (!q.isEmpty()){
            int[] temp = q.poll();
            int tx= temp[0];
            int ty = temp[1];

            for(int i=0;i<4;i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(0<=nx && 0<=ny && nx<n && ny< m && !visited[nx][ny] && map[nx][ny]==0){
                    visited[nx][ny] =true;
                    map[nx][ny] = -1;
                    q.add(new int[] {nx,ny});
                }
            }
        }
    }

    static void fuze(List<int[]> point){
        for(int i=0;i<point.size();i++){
            int tx = point.get(i)[0];
            int ty = point.get(i)[1];
            map[tx][ty] = -1;
            sum++;
        }
    }


}