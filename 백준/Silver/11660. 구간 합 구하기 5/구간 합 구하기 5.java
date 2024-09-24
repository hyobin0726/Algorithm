
import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int[][] arr;
    static int[][] sum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        arr =new int[n+1][n+1];
        sum = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sum[1][1] = arr[1][1];
        for(int i=1; i<=n; i++){
            for(int j= 1; j<=n; j++){
                sum[i][j] = (sum[i][j - 1] + arr[i][j]);

            }
        }
       
        for(int i=0; i<m;i++){
            int result=0;
            st = new StringTokenizer(br.readLine());
            int x1 =  Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 =  Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j=x1; j<=x2; j++) {
                result += (sum[j][y2] - sum[j][y1 - 1]);
            }
            System.out.println(result);
        }
    }
}
