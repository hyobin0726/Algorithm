import java.io.*;
import java.util.*;
public class Solution {
	static int n;
	static int b;
	static int[] tall;
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test =1; test<t+1; test++) {
			result = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			tall = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i =0; i<n;i++) {
				tall[i] =Integer.parseInt(st.nextToken());
			}
			
			for (int i =1; i<n+1;i++) {
				top(i,0,0,0);
			}
			System.out.println("#" +test+" "+result);
			
		}
	}
	static void top(int temp, int cnt,int x, int idx) {
		
		if(temp == cnt) {
			if(x<b) {
				return;
			}
			x= Math.abs(b-x);
			
			if(result>x) {
				result=x;
			}
			return;
		}
		
		for(int i=idx; i<n; i++) {
			int tx =tall[i];
			top(temp, cnt+1,x+tx,i+1);
		}
	}
}
