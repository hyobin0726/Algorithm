import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] g;
    static int hero_hp, hero_attack, boss_hp, boss_attack;
    static int hero_x, hero_y, boss_x, boss_y;
    static int hero_dir, boss_dir;
    static Set<String> stones = new HashSet<>();

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동남서북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
                if (g[i][j] == 2) {
                    hero_x = i;
                    hero_y = j;
                    g[i][j] = 0;
                } else if (g[i][j] == 3) {
                    boss_x = i;
                    boss_y = j;
                    g[i][j] = 0;
                } else if (g[i][j] == 1) {
                    stones.add(i + "," + j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        hero_hp = Integer.parseInt(st.nextToken());
        hero_attack = Integer.parseInt(st.nextToken());
        boss_hp = Integer.parseInt(st.nextToken());
        boss_attack = Integer.parseInt(st.nextToken());

        setInitialDirection();

        while (true) {
            // 아리의 공격 시작
            boss_hp -= hero_attack;
            if (boss_hp <= 0) {
                System.out.println("VICTORY!");
                return;
            }

            // 아리의 이동
            int hero_saved_x = boss_x;
            int hero_saved_y = boss_y;
            for (int k = 0; k < 4; k++) {
                int nx = hero_x + dir[hero_dir][0];
                int ny = hero_y + dir[hero_dir][1];
                if (isValidMove(nx, ny) && !(nx == boss_x && ny == boss_y)) {
                    hero_saved_x = hero_x;
                    hero_saved_y = hero_y;
                    hero_x = nx;
                    hero_y = ny;
                    break;
                } else {
                    hero_hp--;
                    hero_dir = (hero_dir + 1) % 4;
                    if (hero_hp <= 0) {
                        System.out.println("CAVELIFE...");
                        return;
                    }
                }
            }

            // 보스의 공격
            if (!stones.isEmpty()) {
                if (bossAttack()) {
                    System.out.println("CAVELIFE...");
                    return;
                }
            }

            // 보스의 이동
            boss_x = hero_saved_x;
            boss_y = hero_saved_y;
            boss_dir = hero_dir;
        }
    }

    static void setInitialDirection() {
        for (int i = 0; i < 4; i++) {
            int dx = dir[i][0], dy = dir[i][1];
            if (hero_x == boss_x + dx && hero_y == boss_y + dy) {
                hero_dir = boss_dir = i;
                break;
            }
        }
    }

    static boolean isValidMove(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0;
    }

    static boolean bossAttack() {
        int temp_x = boss_x, temp_y = boss_y, temp_dir = boss_dir;
        int cnt = 1;

        while (true) {
            cnt++;
            int dx = dir[temp_dir][0], dy = dir[temp_dir][1];
            for (int i = 0; i < cnt / 2; i++) {
                temp_x += dx;
                temp_y += dy;
                if (stones.contains(temp_x + "," + temp_y)) {
                    return bossAttackFromStone(temp_x, temp_y);
                }
            }
            temp_dir = (temp_dir + 1) % 4;
            if (cnt >= n * m) break;
        }
        return false;
    }

    static boolean bossAttackFromStone(int stone_x, int stone_y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{stone_x, stone_y, boss_attack});
        visited[stone_x][stone_y] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1], attack = pos[2];

            if (x == hero_x && y == hero_y) {
                hero_hp -= attack;
                if (hero_hp <= 0) return true;
                break;
            }

            if (attack <= 0) continue;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && g[nx][ny] != 1 && !visited[nx][ny] && !(nx == boss_x && ny == boss_y)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, attack - 1});
                }
            }
        }
        return false;
    }
}