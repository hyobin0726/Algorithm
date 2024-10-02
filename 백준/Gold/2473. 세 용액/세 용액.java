import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static long min;
    static int ans, ans1, ans2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        min = Long.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            two(i, i + 1);
        }

        // 결과 출력
        System.out.println(ans + " " + ans1 + " " + ans2);
    }

    static void two(int x, int start) {
        int s = start;
        int e = n - 1;

        while (s < e) {
            long temp = (long) arr[x] + arr[s] + arr[e];

            if (Math.abs(temp) < min) {
                min = Math.abs(temp);
                ans = arr[x];
                ans1 = arr[s];
                ans2 = arr[e];
            }

            if (temp == 0) {
                // 정확한 0이면 즉시 반환
                return;
            } else if (temp < 0) {
                s++;
            } else {
                e--;
            }
        }
    }
}