import java.io.*;
import java.util.*;
public class Main{
    static int n;
    static int[] B;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A= new int[n];
        B= new int[n];
        for(int i=0; i<n; i++){
            A[i]=Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            B[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int sum=0;

        for(int i=0; i<n; i++){
            sum+= A[i]*B[n-1-i];
        }

        System.out.println(sum);

    }
}
