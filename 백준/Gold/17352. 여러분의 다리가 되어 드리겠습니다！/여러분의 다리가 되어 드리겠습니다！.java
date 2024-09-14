import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer st;

        for(int i =1; i<=n; i++){
            arr[i] = i;
        }
        for(int i =0; i<n-2; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            union(t1,t2);
        }
        for(int i=2; i<=n; i++){
            if(find(1,i)){
                System.out.println(1 + " " + i);
                break;
            }
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
