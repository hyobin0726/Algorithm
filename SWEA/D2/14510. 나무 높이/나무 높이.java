
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test=1 ; test<t+1; test++ ) {
            int n = Integer.parseInt(br.readLine());
            int[] tree = new int[n];
            int m = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
                if (m < tree[i]) {
                    m = tree[i];
                }
            }

            int one= 0;
            int two=0;

            int ans =0;

            for (int i = 0; i < n; i++) {
                int temp = (m - tree[i]);

                one += (temp%2);
                two += (temp/2);
            }

            if (one<two){
                while (Math.abs(two-one)>1) {
                    --two;
                    ++one;
                    ++one;
                }
            }


            if( one == two){
                ans+=one*2;
            }else if ( one > two){
                ans+=one*2-1;
            }else if (two>one){
                ans+=two*2;
            }

            System.out.println("#" + test + " " + ans);
        }
    }
}
