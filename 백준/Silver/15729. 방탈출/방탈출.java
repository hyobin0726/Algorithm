import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+2];
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt=0;
        for(int i =0; i<n; i++){
            if(arr[i] ==1){
                cnt++;
                arr[i] = (arr[i]+1)%2;
                arr[i+1] = (arr[i+1]+1)%2;
                arr[i+2] = (arr[i+2]+1)%2;
            }
        }
        System.out.println(cnt);

    }
}