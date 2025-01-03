import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        //arr 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        //수열 값 저장
        int[] numlist = new int[n+1];
        int length = 0;
        numlist[0] = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {

            //이분탐색
            if(arr[i]  > numlist[length]){
                length++;
                dp[i] = length;
                numlist[length] = arr[i];
            }else {
                int s = 0;
                int e = length;

                while (s<e){
                    int mid = (s+e)/2;

                    if(numlist[mid] < arr[i]){
                        s = mid+1;
                    }else {
                        e = mid;
                    }
                }
                dp[i] = s;
                numlist[s] = arr[i];
            }

        }

        System.out.println(length);
        //역추적
        for(int i = n-1; i >= 0; i--) {
            if(length == dp[i]) {
                stack.add(arr[i]);
                length--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);

    }
}