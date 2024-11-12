import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int two =0;
		int one = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			two += temp/2;
			one += temp%2;
		}
		
		if(two>= one) {
			two-=one;
			two *=2;
			if(two%3 ==0) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}else {
			System.out.println("NO");
		}
	}

}