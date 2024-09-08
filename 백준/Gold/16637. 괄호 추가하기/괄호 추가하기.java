
import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[] num;
    static char[] op;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 수식의 길이
        String s = br.readLine(); // 수식
        num = new int[n/2+1]; // 수식의 숫자
        op = new char[n/2]; // 수식의 연산자
        int idx = 0;
        for(int i=0; i<n; i++) {
            if(i%2==0) num[idx++] = s.charAt(i)-'0';
            else op[idx-1] = s.charAt(i);
        }
        dfs(0, num[0]);
        System.out.println(max);

    }
    static void dfs(int idx, int ans){
        if(idx == n/2) {
            // 최대값 갱신
            max = Math.max(max, ans);
            return;
        }

        dfs(idx+1, calc(ans, num[idx+1], op[idx]));
        if(idx+1<n/2) {
            int temp = calc(num[idx+1], num[idx+2], op[idx+1]);
            int result = calc(ans, temp, op[idx]);
            dfs(idx+2, result);
        }

    }

    static int calc(int a, int b, char op) {
        if(op=='+') return a+b;
        else if(op=='-') return a-b;
        else return a*b;
    }
}
