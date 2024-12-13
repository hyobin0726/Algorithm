import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        int[] ans = new int[n+1];
        ans[0] =1;
        for(int i=2; i<=n; i++){
            num[i] = num[i-1]+1;
            ans[i] = i-1;

            if(i%2 ==0 ){
                if(num[i] >  num[i/2]+1){
                    ans[i] = i/2;
                }
                num[i] = Math.min(num[i], num[i/2]+1);


            }
            if(i%3 == 0){
                if(num[i] >  num[i/3]+1){
                    ans[i] = i/3;
                }
                num[i] = Math.min(num[i], num[i/3]+1);

            }
        }

        System.out.println(num[n]);
//        System.out.println(Arrays.toString(ans));
        StringBuilder sb = new StringBuilder();
        int temp = n;
        while (temp>0){
            sb.append(temp + " ");
            temp = ans[temp];
        }
        System.out.println(sb);
    }
}