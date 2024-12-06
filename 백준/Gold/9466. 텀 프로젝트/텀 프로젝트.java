import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] num;
    static boolean[] check, cycle;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            n = Integer.parseInt(br.readLine());
            num = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n;i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            check = new boolean[n+1];
            cycle = new boolean[n+1];
            cnt = 0;
            //bfs는 시간초과로 dfs로 변경
            for(int i=1; i<=n; i++){
                    dfs(i);
            }
            System.out.println(n-cnt);


        }
    }
    static void dfs(int x){
        check[x] = true; 
        int temp = num[x];
        if(check[temp] == false){
            dfs(temp);
        }else {
            if(!cycle[temp]){
                cnt++;
                //사이클체크(중요)
                while (x != temp){
                    cnt++;
                    temp = num[temp];
                }
            }

        }
        cycle[x] = true;
    }
}