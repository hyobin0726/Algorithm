import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		ArrayList<String> str;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test =1; test<t+1; test++) {
		StringTokenizer st = new  StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		String input = br.readLine();
		
		str = new ArrayList<>();
		for (int i =0; i<4; i++) {
			if(!str.contains(input.substring(i*n/4,i*n/4+n/4))) {
				str.add(input.substring(i*n/4,i*n/4+n/4));
			}
		}
	
		int cnt=0;
		while (cnt< n/4-1) {
			input = input.substring(1,n)+input.substring(0,1);
			
			for (int i =0; i<4; i++) {
				if(!str.contains(input.substring(i*n/4,i*n/4+n/4))) {
					str.add(input.substring(i*n/4,i*n/4+n/4));
				}
			}
			
			cnt++;
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i=0; i<str.size();i++) {
			result.add(Integer.parseInt(str.get(i),16));
		}
		Collections.sort(result, Collections.reverseOrder());
		System.out.println("#"+test+" "+ result.get(k-1));
		
		}
	}
}
