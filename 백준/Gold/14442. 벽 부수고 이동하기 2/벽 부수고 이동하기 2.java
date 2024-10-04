import java.io.*;
import java.util.*;

public class Main {
    static int n, m,k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class wall{
        int x,y,sum;
        int destroy;

        public wall(int x, int y, int sum, int destroy) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.destroy = destroy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
    }

    static void bfs() {
        Queue<wall> q = new LinkedList<>();
        //x,y,칸이동수, 벽부신여부
        q.add(new wall (0, 0, 1,0));
        visited = new boolean[n][m][k+1];
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            wall temp = q.poll();
            if (temp.x == n - 1 && temp.y == m - 1) {
                System.out.println(temp.sum);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m ){
                    //벽아닌경우
                    if(map[nx][ny] == 0) {
                        if (!visited[nx][ny][temp.destroy]) {
                            q.add(new wall(nx, ny, temp.sum + 1, temp.destroy));
                            visited[nx][ny][temp.destroy] = true;
                        }
                    }
                    //벽인경우
                    else {
                        if(temp.destroy <k && !visited[nx][ny][temp.destroy+1]){
                            q.add(new wall(nx,ny,temp.sum+1, temp.destroy+1));
                            visited[nx][ny][temp.destroy+1] =true;
                        }
                    }
                }}
        }
        System.out.println(-1);
    }
}