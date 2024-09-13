
import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int max = 1000000; //최대 부품수
        n =Integer.parseInt(br.readLine());
        arr = new int[max+1];
        size = new int[max+1];
        for(int i=1; i<= max; i++){
            arr[i]=i;
            size[i] = 1;
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            if(tmp.equals("I")){
                int t1 = Integer.parseInt(st.nextToken());
                int t2 = Integer.parseInt(st.nextToken());
                union(t1,t2);

            }else if (tmp.equals("Q")) {
                int t3 = Integer.parseInt(st.nextToken());
                int temp = size[get(t3)];
                sb.append(temp + "\n");
//                System.out.println(size[get(t3)]);
//                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(sb);
    }
    static int get(int x ){
        if (arr[x] == x) return x;
        return arr[x] = get(arr[x]);
    }

    static void union (int x , int y){
        int a= get(x);
        int b = get(y);

        if(a==b) return;

        arr[a] = b;
        size[b] += size[a];


    }
}
