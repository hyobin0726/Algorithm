import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        int k;
        int[][] medal;
        boolean[] check;
        int ans=1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        medal = new int[n+1][3];
        check = new boolean[n+1];
        for (int i =0; i<n ; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            for(int j=0; j<3; j++){
                medal[tmp][j] = Integer.parseInt(st.nextToken());
            }
            check[tmp] = false;
        }

        for (int i =0; i<3 ; i++){
            boolean is= false;
            for(int j=1; j<n+1; j++){
                if(medal[k][i] == 0 && !check[j]){
                    if(medal[k][i] <medal[j][i]){
                        check[j] = true;
                        ans++;
                    }
                }else {
                    is = true;
                    if(medal[k][i] <medal[j][i] && !check[j]){
                        check[j] = true;
                        ans++;
                    }
                }
            }
            if(is){
                break;
            }
        }
        System.out.println(ans);


    }

}
