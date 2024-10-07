import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int tmin = Integer.MAX_VALUE;
        int tmax = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            tmin = Math.min(tmin, arr[i]);
            tmax = Math.max(tmax,arr[i]);
        }
        int start = 0;
        int end =tmax-tmin;
        int mid =0;
        int ans = Integer.MAX_VALUE;
        while (start<= end){
            mid = (start+end)/2;
            int tempmin = arr[0];
            int tempmax = arr[0];
            int cnt =1;
            for(int i =0; i<n; i++){
                tempmin = Math.min(tempmin,arr[i]);
                tempmax = Math.max(tempmax,arr[i]);
                if(tempmax-tempmin>mid){
                    cnt++;
                    tempmax = tempmin = arr[i];
                }
            }
//            System.out.println(cnt + " " + mid);
            if(cnt<=m){
                ans = Math.min(ans,mid);
                end = mid-1;
            }else {
                start = mid+1;
            }

        }

        System.out.println(ans);

    }
}