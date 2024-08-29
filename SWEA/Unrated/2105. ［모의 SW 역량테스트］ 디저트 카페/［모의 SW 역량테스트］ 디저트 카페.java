import java.io.*;
import java.util.*;
class Solution {
    static int N;
    static int[][] map;

    static int[] dx = { 1/* 오른쪽 아래 */, 1/* 왼쪽 아래 */, -1/* 왼쪽 위 */, -1/* 오른쪽 위 */ };
    static int[] dy = { 1, -1, -1, 1, };
    static boolean[][] visited;
    static boolean[] dessert;
    static int max;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            max=0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }

            }

            for (int i = 0; i < N - 2; i++) {
                for (int j = 1; j < N - 1; j++) {
                    visited = new boolean[N][N];
                    dessert = new boolean[101];
                    visited[i][j] = true;
                    dessert[map[i][j]] = true;
                    dfs(1, i, j, i, j, 0);
                }
            }

            if (max == 0)
                max = -1;

            System.out.println("#" + test_case + " " + max);

        }

        System.out.println(sb);

    }

    private static void dfs(int cnt, int r, int c, int initR, int initC, int prevD) {
        for (int i = prevD; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if ((nr == initR) && (nc == initC) && cnt > 2) {
                    max = Math.max(max, cnt);
                    return;
                }

                if (!visited[nr][nc] && !dessert[map[nr][nc]]) {
                    visited[nr][nc] = true;
                    dessert[map[nr][nc]] = true;
                    dfs(cnt + 1, nr, nc, initR, initC, i);
                    visited[nr][nc] = false;
                    dessert[map[nr][nc]] = false;
                }
            }

        }

    }

}
