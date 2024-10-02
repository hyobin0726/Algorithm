import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr=new int[n+1];
        dp=new int[n+1];
        ArrayList<Integer>[] dplist = new ArrayList[n+1];
        for(int i=1; i<= n; i++){
            dplist[i] = new ArrayList<>();
        }

        st= new StringTokenizer(br.readLine());
        for(int i=1; i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = 1;
        dplist[1].add(arr[1]);
        int max = dp[1];
        int idx = 1;
        for(int i=2; i<=n ; i++){
            dp[i] = 1;
            dplist[i].add(arr[i]);
            for(int j=1; j<i; j++){
                if(arr[i] > arr[j] && dp[i]<= dp[j]){
                    dp[i] = dp[j]+1;
                    dplist[i]= new ArrayList<>(dplist[j]);
                    dplist[i].add(arr[i]);
                }
            }
            if(max<dp[i]){
                max = dp[i];
                idx = i;
            }
        }
        System.out.println(max);
//        System.out.println(idx);
        StringBuilder sb = new StringBuilder();
        for(int t : dplist[idx]){
            sb.append(t + " ");
        }
        System.out.println(sb);

    }
}