import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            if(n > m){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }

    }
}