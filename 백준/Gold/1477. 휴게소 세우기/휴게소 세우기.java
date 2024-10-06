import java.io.*;
import java.util.*;

public class Main {
    static int n, m, l;
    static int[] rest;
    static int[] interval;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        rest = new int[n+2];
        interval = new int[n+1];
        rest[n+1] = l;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            rest[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rest);
        for(int i=0; i<=n; i++){
            interval[i] = (rest[i+1]-rest[i]);
        }
        Arrays.sort(interval);
        int start = 1;
        int end = interval[n];
        int mid = 0;
        int min = Integer.MAX_VALUE;

        while (start<= end){
            mid = (start+end)/2;

            int cnt =0;
            for(int i=0; i<=n; i++){
                cnt += (interval[i]-1) / mid;
            }
            if(cnt<= m){
                min = Math.min(min, mid);
                end= mid-1;
            } 
            else if ( cnt > m) {
                start = mid +1;
            }
        }
        System.out.println(min);

    }
}