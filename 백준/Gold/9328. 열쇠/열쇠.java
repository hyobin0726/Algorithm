import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static char[][] map;
    static boolean[] key;
    static boolean[][] visited;
    static int ans;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<int[]>[] waitGate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            //테두리를 만들어 모든곳에서 입장가능하도록
            map = new char[h+2][w+2];
            visited = new boolean[h+2][w+2];
            waitGate = new ArrayList[26];
            for (int j = 0; j < 26; j++) waitGate[j] = new ArrayList<>();
            key = new boolean[26];
            ans = 0;

            Queue<int[]> q = new LinkedList<>();

            // 입력 처리
            for (int j = 0; j < h; j++) {
                String line = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j+1][k+1] = line.charAt(k);
                }
            }
            for(int j=0; j<h+2; j++){
                map[j][0] = '.';
                map[j][w+1]= '.';
            }
            for(int j=0; j<w+2; j++){
                map[0][j] = '.';
                map[h+1][j]= '.';
            }

//            for(int j=0; j<h+2; j++){
//                for(int k=0; k<w+2; k++){
//                    System.out.print(map[j][k] + " ");
//                }
//                System.out.println();
//            }
            // 초기 열쇠 처리
            String keys = br.readLine();
            if (keys.charAt(0) != '0') {
                for (int j = 0; j < keys.length(); j++) {
                    key[keys.charAt(j) - 'a'] = true;
                }
            }

            q.add(new int[] {0,0});
            visited[0][0] = true;
            // BFS 탐색
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= h+2 || ny >= w+2 || visited[nx][ny]) continue;

                    char c = map[nx][ny];
                    //벽
                    if (c == '*') continue;

                    //문서
                    if (c == '$') {
                        visited[nx][ny] = true;
                        ans++;
                        map[nx][ny] = '.';
                        q.add(new int[]{nx, ny});
                    } else if (c == '.') {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    } else if (c >= 'A' && c <= 'Z') {
                        //키가 있다면
                        if (key[c - 'A']) {
                            visited[nx][ny] = true;
                            map[nx][ny] = '.';
                            q.add(new int[]{nx, ny});
                        } else {
                            waitGate[c - 'A'].add(new int[]{nx, ny});
                        }
                    } else if (c >= 'a' && c <= 'z') {
                        int newKey = c - 'a';
                        map[nx][ny] = '.';
                        key[newKey] = true;
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        // 새로 발견된 열쇠로 열 수 있는 문 처리
                        for (int[] pos : waitGate[newKey]) {
                            if (!visited[pos[0]][pos[1]]) {
                                q.add(pos);
                                visited[pos[0]][pos[1]] = true;
                            }
                        }
                    }
                }
            }

            System.out.println(ans);
        }
    }
}