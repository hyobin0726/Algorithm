import java.util.*;
import java.io.*;
public class Main {
    static Long n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        binary();

    }
    static void  binary(){
        long start = 0;
        long end = n;
        long mid = 0;

        while (start <= end){
            mid = (start+end)/2;
            long temp = (mid+1)*(n-mid+1);

            if(temp == k){
                System.out.println("YES");
                return;
            } else if (temp >k) {
                end = mid-1;
            } else if (temp<k) {
                start = mid+1;
            }
        }
        System.out.println("NO");

    }

}