
import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(n, m) / 2;
        for (int s = 0; s < layers; s++) {
            int layerPerimeter = 2 * (n - 2 * s) + 2 * (m - 2 * s) - 4;
            int effectiveR = r % layerPerimeter;

            for (int round = 0; round < effectiveR; round++) {
                int temp = map[s][s];
                
                // 위쪽
                for (int i = s; i < m - 1 - s; i++) {
                    map[s][i] = map[s][i + 1];
                }
                // 오른쪽
                for (int i = s; i < n - 1 - s; i++) {
                    map[i][m - 1 - s] = map[i + 1][m - 1 - s];
                }
                // 아래쪽
                for (int i = m - 1 - s; i > s; i--) {
                    map[n - 1 - s][i] = map[n - 1 - s][i - 1];
                }
                // 왼쪽
                for (int i = n - 1 - s; i > s; i--) {
                    map[i][s] = map[i - 1][s];
                }

                map[s + 1][s] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}