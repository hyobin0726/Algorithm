import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr=new int[n+1];
        dp=new long[n+1];
        st= new StringTokenizer(br.readLine());
        for(int i=1; i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        int idx = 2;
        for(int i=2; i<=n; i++){
            int temp = arr[i];

            if(dp[idx-1] < temp){
                dp[idx] = temp;
                idx++;
            }else {
                long s = 1;
                long e = idx;

                while (s<e){
                    long mid =((long) (s+e)/2);

                    if(dp[(int) mid] < temp){
                        s = mid+1;
                    }else {
                        e = mid;
                    }
                }
                dp[(int) s] = temp;
            }
        }
        System.out.println(idx-1);

    }
}