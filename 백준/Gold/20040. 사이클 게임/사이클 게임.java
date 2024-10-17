import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]=i;
        }
        int result = 0;
        for(int i=1; i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!union(a,b)){
                result=i;
                break;
            }
        }
        System.out.println(result);
    }
    static int find(int a){
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }
    static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);
        if( x == y ) return false;
        arr[y] =x;
        return true;
    }
}