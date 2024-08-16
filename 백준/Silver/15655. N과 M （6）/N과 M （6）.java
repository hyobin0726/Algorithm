import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static int[] num;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        visited = new boolean[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        nm(0, result,0);

    }
    static void nm(int cnt, int[] result, int idx) {
        if (cnt == m){
            for(int i=0 ; i<m; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=idx; i<n; i++){
        	result[cnt] = num[i];
            nm(cnt+1, result, i+1);
    
        }

    }

}
