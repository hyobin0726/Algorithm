
import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static int k;
    static int[] arr;
    static int[] cost;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for(int i=0; i<= n; i++){
            arr[i]=i;
        }
        st = new StringTokenizer(br.readLine());
        cost = new int[n+1];
        for(int i=1;i<=n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int tmp1= Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            union(tmp1,tmp2);
        }
        int temp =0;
        for(int i= 1 ; i<=n ; i++){
            temp+= cost[i];
        }
        if (temp <= k) {
            System.out.println(temp);
        }else {
            System.out.println("Oh no");
        }

    }
    static int get(int x ){
        if (arr[x] == x) return x;
        return arr[x] = get(arr[x]);
    }

    static void union (int x , int y){
        int a= get(x);
        int b = get(y);

        if(a!=b){
            if(cost[a]<cost[b]){
                arr[b] = a;
                cost[b] = 0;
            }else {
                arr[a] = b;
                cost[a] = 0;

            }
        }
    }

}
