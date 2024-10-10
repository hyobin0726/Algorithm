import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n+1][n+1];
        StringTokenizer st;
        for(int i=1;i<=n;i++){
            for(int j=1; j<=n; j++){
                if(i == j){cost[i][j] =0;}
                else {cost[i][j] = 1000001;}
            }
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        cost[s][e] = Math.min(cost[s][e], 1);
        cost[e][s] = Math.min(cost[e][s], 1);
        while (s != -1 && e != -1){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            if(s != -1 && e != -1){
                cost[s][e] = Math.min(cost[s][e], 1);
                cost[e][s] = Math.min(cost[e][s], 1);
            }
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(cost[i][j] >0) {
                        cost[i][j] = Math.min(cost[i][k] + cost[k][j], cost[i][j]);
                    }
                }
            }
        }
        int max=1000001;
        int cnt =0;
        List<Integer> person = new ArrayList<>();
        for(int i=1 ; i<=n; i++){
            int temp =0;
            for(int j=1;j<=n;j++){
                if(cost[i][j] > temp){
                    temp=cost[i][j];
                }
            }if(max > temp){
                person = new ArrayList<>();
                max=temp;
                person.add(i);
                cnt=1;

            }else if( max == temp){
                person.add(i);
                cnt++;
            }
        }
        System.out.println(max + " " + cnt);
        StringBuilder sb = new StringBuilder();
        for (int p : person) {
            sb.append(p).append(" ");
        }
        System.out.println(sb);
    }
}