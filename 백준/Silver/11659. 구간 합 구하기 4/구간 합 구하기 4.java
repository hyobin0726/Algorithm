
import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        arr =new int[n+1];
        sum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){

            arr[i] = Integer.parseInt(st.nextToken());

        }
        for(int i=1; i<=n; i++){
            sum[i] = (sum[i-1] + arr[i]);
        }
    
        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x1 =  Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            System.out.println(sum[y1] - sum[x1-1]);
        }
    }
}
