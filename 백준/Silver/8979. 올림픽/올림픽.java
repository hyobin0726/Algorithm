import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] medal = new int[n + 1][3]; // [국가][0:금,1:은,2:동]

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            medal[id][0] = Integer.parseInt(st.nextToken()); // 금
            medal[id][1] = Integer.parseInt(st.nextToken()); // 은
            medal[id][2] = Integer.parseInt(st.nextToken()); // 동
        }

        int ans = 1; // 기본 순위 1위
        for (int j = 1; j <= n; j++) {
            if (j == k) continue;
            // j가 k보다 사전식으로 “엄격히 더 크면” (금> || (금== && 은>) || (금== && 은== && 동>))
            if (medal[j][0] > medal[k][0]
                || (medal[j][0] == medal[k][0] && medal[j][1] > medal[k][1])
                || (medal[j][0] == medal[k][0] && medal[j][1] == medal[k][1] && medal[j][2] > medal[k][2])) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
