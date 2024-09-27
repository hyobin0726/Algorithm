import java.util.*;
import java.io.*;
public class Main {
	static int n,m;
	static int[] point;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		point = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(point);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int t1 = lower(Integer.parseInt(st.nextToken()));
			int t2 = upper(Integer.parseInt(st.nextToken()));
//			System.out.println(t2 + " "+ t1 + " ");
			System.out.println(t2-t1);
		}
		
	}
	static int lower(int x) {
//		System.out.println("?");
		int start =0;
		int end = n;
	
		while(start<end) {
			int mid = (start+end)/2;
	
			if(x<=point[mid]) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
	
		return end;
	}
	static int upper(int x) {
//		System.out.println("!");
		int start =0;
		int end = n;

		while(start<end) {
			int mid = (start+end)/2;
			if(x>=point[mid]) {
				start = mid+1;
				
			}else {
				end = mid;
			}
		}

		return end;
	}
}