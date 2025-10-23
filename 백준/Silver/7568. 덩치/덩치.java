import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int[][] list = new int[n][2];
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            list[i][0]= weight;
            list[i][1] = height;
        }

        for(int i=0; i<n; i++){
            int tmp = 1;
            for(int j=0; j<n; j++){
                if(i!=j){
                    if(list[i][0] < list[j][0] && list[i][1] < list[j][1] ){
                        tmp++;
                    }
                }
            }
            ans[i] = tmp;
        }

        for (int i=0; i<n; i++){
            System.out.print(ans[i] + " ");
        }


    }
}
