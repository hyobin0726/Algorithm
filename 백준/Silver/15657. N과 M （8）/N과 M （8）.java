import java.io.*;
import java.util.*;
public class Main {
	static int n ;
	static int m;
	static int[] num;
	static int[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			num[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		result = new int[m];
		nm(0, result,0);
		
	}
	static void nm(int cnt, int[] result,int temp) {
		if(cnt == m) {
			for (int i=0; i<m; i++) {
				System.out.print(result[i]+ " ");
				
			}
			System.out.println();
			return;
		}
		for(int i=temp; i<n;i++) {
			result[cnt] = num[i];
			nm(cnt+1, result, i);
		}
	}
}