import java.io.*;
public class Main {
    static int[] cnt0;
    static int[] cnt1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        //0이 호출되는 경우, 1이 호출되는 경우 메모이제이션
        cnt0 = new int[41];
        cnt1 = new int[41];

        cnt0[0]= 1;
        cnt1[0] =0;
        cnt0[1] =0;
        cnt1[1] = 1;

        for(int tc = 0; tc< t; tc++){
            int n = Integer.parseInt(br.readLine());
            fibore(n);
            sb.append(cnt0[n] + " " + cnt1[n] + "\n");

        }
        System.out.println(sb);

    }
    static void fibore(int x){
        for(int i=2; i<=x; i++){
            if(cnt0[i] == 0 && cnt1[i] == 0 ){ //계산되지않은 경우만
                cnt0[i] = cnt0[i-1] + cnt0[i-2];
                cnt1[i] = cnt1[i-1] + cnt1[i-2];
            }
        }
    }
}
