import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    // 좌하우상
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int cnt;
    static int x, y, d;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        cnt = 0;
        // 토네이도 위치
        x = n / 2;
        y = n / 2;
        d = 0;
        // 남은 양
        ans = 0;
        arr();
        System.out.println(ans);
//		System.out.println((int) Math.floor(99*(0.1)));

    }

    static void arr() {
        boolean isgame = true;
        while (isgame) {
            cnt++;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < cnt; j++) {
                    int temp = 0;

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // 격자 내 있다면
                    // 격자 밖

                    // 5%
                    int tx = nx + dx[d] * 2;
                    int ty = ny + dy[d] * 2;
                    if (check(tx, ty)) {
                        map[tx][ty] += (int) Math.floor(map[nx][ny] * (0.05));

                    } else {
                        ans += (int) Math.floor(map[nx][ny] * (0.05));
                    }
                    temp += (int) Math.floor(map[nx][ny] * (0.05));
                    // 7%
                    tx = nx + dx[(4 + d - 1) % 4];
                    ty = ny + dy[(4 + d - 1) % 4];
                    if (check(tx, ty)) {
                        map[tx][ty] += (int) Math.floor(map[nx][ny] * (0.07));

                    } else {
                        ans += (int) Math.floor(map[nx][ny] * (0.07));
                    }
                    temp += (int) Math.floor(map[nx][ny] * (0.07));
                    // 7%
                    tx = nx + dx[(4 + d + 1) % 4];
                    ty = ny + dy[(4 + d + 1) % 4];
                    if (check(tx, ty)) {
                        map[tx][ty] += (int) Math.floor(map[nx][ny] * (0.07));

                    } else {
                        ans += (int) Math.floor(map[nx][ny] * (0.07));
                    }
                    temp += (int) Math.floor(map[nx][ny] * (0.07));
                    // 2%
                    tx = nx + dx[(4 + d - 1) % 4] * 2;
                    ty = ny + dy[(4 + d - 1) % 4] * 2;
                    if (check(tx, ty)) {
                        map[tx][ty] += (int) Math.floor(map[nx][ny] * (0.02));

                    } else {
                        ans += (int) Math.floor(map[nx][ny] * (0.02));
                    }
                    temp += (int) Math.floor(map[nx][ny] * (0.02));
                    // 2%
                    tx = nx + dx[(4 + d + 1) % 4] * 2;
                    ty = ny + dy[(4 + d + 1) % 4] * 2;
                    if (check(tx, ty)) {
                        map[tx][ty] += (int) Math.floor(map[nx][ny] * (0.02));

                    } else {
                        ans += (int) Math.floor(map[nx][ny] * (0.02));
                    }
                    temp += (int) Math.floor(map[nx][ny] * (0.02));

                    // 10%
                    tx = nx + dx[d] + dx[(4 + d + 1) % 4];
                    ty = ny + dy[d] + dy[(4 + d + 1) % 4];
                    if (check(tx, ty)) {
                        map[tx][ty] += (int) Math.floor(map[nx][ny] * (0.1));

                    } else {
                        ans += (int) Math.floor(map[nx][ny] * (0.1));
                    }
                    temp += (int) Math.floor(map[nx][ny] * (0.1));
                    // 10%
                    tx = nx + dx[d] + dx[(4 + d - 1) % 4];
                    ty = ny + dy[d] + dy[(4 + d - 1) % 4];
                    if (check(tx, ty)) {
                        map[tx][ty] += (int) Math.floor(map[nx][ny] * (0.1));

                    } else {
                        ans += (int) Math.floor(map[nx][ny] * (0.1));
                    }
                    temp += (int) Math.floor(map[nx][ny] * (0.1));
                    // 1%
                    tx = nx + dx[(4 + d + 2) % 4] + dx[(4 + d + 1) % 4];
                    ty = ny + dy[(4 + d + 2) % 4] + dy[(4 + d + 1) % 4];
                    if (check(tx, ty)) {
                        map[tx][ty] += (int) Math.floor(map[nx][ny] * (0.01));

                    } else {
                        ans += (int) Math.floor(map[nx][ny] * (0.01));
                    }
                    temp += (int) Math.floor(map[nx][ny] * (0.01));
                    // 1%
                    tx = nx + dx[(4 + d + 2) % 4] + dx[(4 + d + 3) % 4];
                    ty = ny + dy[(4 + d + 2) % 4] + dy[(4 + d + 3) % 4];
                    if (check(tx, ty)) {
                        map[tx][ty] += (int) Math.floor(map[nx][ny] * (0.01));

                    } else {
                        ans += (int) Math.floor(map[nx][ny] * (0.01));
                    }
                    temp += (int) Math.floor(map[nx][ny] * (0.01));
                    // 앞 알파
                    tx = nx + dx[d];
                    ty = ny + dy[d];
                    if (check(tx, ty)) {
                        map[tx][ty] += (map[nx][ny] - temp);

                    } else {
                        ans += (map[nx][ny] - temp);
                    }

                    map[nx][ny] = 0;
                    x = nx;
                    y = ny;
                    if (x == 0 && y == 0) {
                        isgame = false;
                        return;
                    }
//                    System.out.println(x + " " + y + " " + d);

//                    for (int a = 0; a < n; a++) {
//                        for (int b = 0; b < n; b++) {
//                            System.out.print(map[a][b] + " ");
//                        }
//                        System.out.println();
//                    }

                }
                d = (4 + d + 1) % 4;
            }
        }

    }
    static boolean check(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n) {
            return true;
        }
        return false;
    }
}