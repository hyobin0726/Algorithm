import java.io.*;
import java.util.*;

public class Main {
    static int h,w;
    static int[] map;
    static int[] rain;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h= Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[w];
        rain = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++){
            rain[i] = Integer.parseInt(st.nextToken());
        }
        int i=0;
        while (i<w-1){
            int e= ischeck(i);
            if(rain[i]<=rain[e]) {
                rainy(i,e,rain[i]);
            }else {
                rainy(i,e,rain[e]);
            }
            i=e;

//            System.out.println(i);
//            if(i==4){break;}
//            System.out.println(Arrays.toString(map));
            }

//        System.out.println(Arrays.toString(map));

        int ans=0;
        for(int a=0;a<w;a++){
            if(map[a]>0){
                ans+=map[a];
            }
        }
        System.out.println(ans);


    }
    static int ischeck(int s){
        int tempmax=0;
        int e=0;
        for(int i=s+1; i<w; i++){
//            System.out.println("!!" + i);
            if(rain[s] <= rain[i]){
//                System.out.println("??" + i);
                return i;
            }
            if (tempmax<=rain[i]){
                tempmax= rain[i];
                e=i;
            }
        }
        return e;
    }
    static void rainy(int s, int e, int temp){
        for(int i=s;i<e;i++){
            map[i]= (temp-rain[i]);
        }
    }


}