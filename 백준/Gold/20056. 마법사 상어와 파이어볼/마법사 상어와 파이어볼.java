import java.io.*;
import java.util.*;

public class Main {
    static int n, f, k;
    static List<Fireball>[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        List<Fireball> fireballs = new ArrayList<>();

        for (int i = 0; i < f; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        for (int i = 0; i < k; i++) {
            move(fireballs);
            divide(fireballs);
        }

        int totalMass = 0;
        for (Fireball fb : fireballs) {
            totalMass += fb.m;
        }

        System.out.println(totalMass);
    }

    static void move(List<Fireball> fireballs) {
        map = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (Fireball fb : fireballs) {
            int nx = (fb.r + dx[fb.d] * fb.s % n + n) % n;
            int ny = (fb.c + dy[fb.d] * fb.s % n + n) % n;
            fb.r = nx;
            fb.c = ny;
            map[nx][ny].add(fb);
        }
    }

    static void divide(List<Fireball> fireballs) {
        fireballs.clear();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() == 0) continue;
                if (map[i][j].size() == 1) {
                    fireballs.addAll(map[i][j]);
                    continue;
                }

                int sumM = 0, sumS = 0, count = map[i][j].size();
                boolean allEven = true, allOdd = true;

                for (Fireball fb : map[i][j]) {
                    sumM += fb.m;
                    sumS += fb.s;
                    if (fb.d % 2 == 0) allOdd = false;
                    else allEven = false;
                }

                int nm = sumM / 5;
                int ns = sumS / count;

                if (nm == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nd = (allEven || allOdd) ? d * 2 : d * 2 + 1;
                    fireballs.add(new Fireball(i, j, nm, ns, nd));
                }
            }
        }
    }
}
