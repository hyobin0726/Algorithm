import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int one;
    static int two;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            int temp= Integer.parseInt(st.nextToken());
            if(temp/2 > 0) {
                two+= (temp/2);
            }
            if(temp%2 > 0) {
                one+= (temp%2);
            }
        }
        two -= (one);
    
        if(two*2>= 0){
            if((two*2)%3 == 0){
            System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
       else {
            System.out.println("NO");
        }

    }

}
