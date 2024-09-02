import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노래 수
        int l = Integer.parseInt(st.nextToken()); // 각 노래의 길이
        int d = Integer.parseInt(st.nextToken()); // 전화벨 간격

        int totalTime = n * l + (n - 1) * 5; // 총 시간 계산 (마지막 노래 이후에는 휴식이 없음)

        for (int time = d; time <= totalTime; time += d) {
            int checkTime = time % (l + 5); // 노래와 휴식 구간을 합친 사이클 내의 현재 시간 계산
            if (checkTime >= l) {
                // 현재 시간(time)이 휴식 시간에 해당되면 출력 후 종료
                System.out.println(time);
                return;
            }
        }

        // 만약 전화를 못 받았다면, 마지막 노래 끝난 후의 시간 중에서 전화가 울리는 첫 번째 시간
        System.out.println(((totalTime / d) + 1) * d);
    }
}
