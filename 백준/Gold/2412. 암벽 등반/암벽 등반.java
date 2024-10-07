import java.util.*;
import java.io.*;

public class Main {
    static int n, t;
    static List<arr> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new arr(x, y));
        }

        Collections.sort(list);
        
        bfs();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2];

            if (y == t) {
                System.out.println(cnt);
                return;
            }

            int start = binary(x - 2);
            for (int i = start; i < n; i++) {
                int nx = list.get(i).x;
                int ny = list.get(i).y;

                if (nx > x + 2) break;

                if (Math.abs(y - ny) <= 2 && !visited.contains(nx + "," + ny)) {
                    visited.add(nx + "," + ny);
                    q.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        System.out.println(-1);
    }

    static int binary(int v) {
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid).x >= v) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static class arr implements Comparable<arr> {
        int x, y;

        public arr(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(arr o) {
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }
}