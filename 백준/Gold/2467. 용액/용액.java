import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;
        int ans1 =0;
        int ans2=0;

        while (start< end){
            int temp = Math.abs(arr[start]+arr[end]);
            if(temp<min){
                min = temp;
                ans1 = arr[start];
                ans2 = arr[end];
            }
            if(arr[start]+arr[end]==0){
                System.out.println(ans1 + " " + ans2);
                return;
            }
            else if(arr[start]+arr[end]<0){
                start++;
            }else {
                end--;
            }
        }
        System.out.println(ans1 + " " + ans2);
     }
}