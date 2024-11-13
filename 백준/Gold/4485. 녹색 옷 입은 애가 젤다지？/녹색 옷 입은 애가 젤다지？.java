import java.io.*;
import java.util.*;

public class Main {

    static int N,map[][];
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt =1;
        while (true) {
            N = Integer.parseInt(in.readLine());
            if(N == 0){
                break;
            }
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Problem " + cnt + ": " +getMinTime(0, 0, N - 1, N - 1));
            cnt++;
        }
    }

    static int getMinTime(int sr,int sc, int er,int ec) {
        final int INF = Integer.MAX_VALUE;
        int[][] minTime = new int[N][N];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                minTime[i][j] = INF;
            }
        }

        minTime[sr][sc] = map[0][0];
        q.add(new int[] {sr,sc,minTime[sr][sc]});

        while(!q.isEmpty()) {
            int[] stopOver = q.poll();
            int r = stopOver[0];
            int c = stopOver[1];
            int time = stopOver[2];
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr>=0 && nr<N && nc>=0 && nc<N && minTime[nr][nc]> time+map[nr][nc]) {
                    minTime[nr][nc] = time+map[nr][nc];
                    q.add(new int[] {nr,nc,minTime[nr][nc]});
                }
            }
        }
//        if(r==er && c==ec) {
        return minTime[N-1][N-1];
//        }
//        return -1;
    }

}