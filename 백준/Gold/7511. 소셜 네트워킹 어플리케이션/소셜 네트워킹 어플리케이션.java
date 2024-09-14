import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int t= Integer.parseInt(br.readLine());
        for(int tc =1; tc<= t; tc++){
            sb = new StringBuilder();
            n = Integer.parseInt(br.readLine());
            arr= new int[1000001];
            for(int i=0; i<1000001; i++){
                arr[i] = i;
            }
            int k = Integer.parseInt(br.readLine());
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int t1 = Integer.parseInt(st.nextToken());
                int t2= Integer.parseInt(st.nextToken());
                union(t1,t2);
            }
            int m = Integer.parseInt(br.readLine());
            System.out.println("Scenario "+ tc + ":");
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int t1 = Integer.parseInt(st.nextToken());
                int t2= Integer.parseInt(st.nextToken());
                if(find(t1,t2)){
                    sb.append(0 + "\n");
                }else {
                    sb.append(1 + "\n");
                }
            }
            System.out.println(sb);
        }

    }
    static int get(int x ){
        if (arr[x] == x) return x;
        return arr[x] = get(arr[x]);
    }
    static boolean find (int x, int y){
        int a = get(x);
        int b = get(y);
        if(a ==b) return false;
        return true;

    }
    static void union (int x , int y){
        int a= get(x);
        int b = get(y);
        if(a ==b) return;
        if(a<b) {
            arr[b] = a;
        }else {
            arr[a] = b;
        }
    }
}
