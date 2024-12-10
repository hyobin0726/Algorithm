import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<double[]> num; 
    static double ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            num.add(new double[] {x, y});
        }
        ans = 0;
        for (int i = 1; i < n - 1; i++) {
            double x = num.get(0)[0];
            double y = num.get(0)[1];
            double x1 = num.get(i)[0];
            double y1 = num.get(i)[1];
            double x2 = num.get(i + 1)[0];
            double y2 = num.get(i + 1)[1];

            double temp1 = x * y1 + x1 * y2 + x2 * y;
            double temp2 = x1 * y + x2 * y1 + x * y2;

            ans += (temp1 - temp2); 
        }

        ans = Math.abs(ans) / 2.0; 

        System.out.printf("%.1f\n", ans);
    }
}