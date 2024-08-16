import java.io.*;
import java.util.*;
public class Solution {
	static Queue<Integer> num ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int t=0; t<10; t++ ) {
			int test = Integer.parseInt(br.readLine()); 
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = new LinkedList<>();
			for (int i=0; i<8; i++) {
				num.add(Integer.parseInt(st.nextToken()));
			}
			pw();
			sb = new StringBuilder();
			for (int i=0; i<8;i++) {
				sb.append(num.poll()).append(" ");
			}
			System.out.print("#" + test + " ");
			System.out.println(sb);
		}
	}
	static void pw() {
		while (true) {
			for (int i=1; i<6;i++) {
				int temp = num.poll();
				temp-=i;
				if(temp > 0) {
					num.add(temp);
				
				}else {
					temp =0;
					num.add(temp);
					return;
				}
			
			}
		}
}
}
