import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int time = 0;
        int temp = 0;
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            time += d - temp;
            temp = d;

            int cycle = r + g;

            if (time % cycle < r) {
                time += r - time % cycle;
            }
        }
        time += l - temp;

        System.out.println(time);
    }
}
