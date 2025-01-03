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
		int[] dp = new int[n];
		int length = 0;
		int max_idx = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			// arr 현재 요소 받기
			int ele = Integer.parseInt(st.nextToken());
			arr[i] = ele;
			
			// 현재 요소를 받고 dp 시작
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < ele) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			
			// 최댓값, 최대인덱스를 저장한다.
			if(length < dp[i]) {
				length = dp[i];
				max_idx = i;
			}
		}
		
		System.out.println(length);
		
		for(int i = max_idx; i >= 0; i--) {
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