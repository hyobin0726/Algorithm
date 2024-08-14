import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int m;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		mn(0 , arr,0);
	}
	static void mn(int cnt, int[] temp , int start) {
		if(cnt == m) {
			for (int i=0; i<m; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i =start; i<n; i++) {
			temp[cnt]=i+1;
			mn(cnt+1, temp , i);
		}
	}
}
