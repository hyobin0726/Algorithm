import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
  public static void main(String[] args) throws Exception {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  
	  int T = Integer.parseInt(br.readLine());
	  
	  for (int i = 1; i <= T; i++) {
		  
		int sum = 0;
		StringTokenizer arr = new StringTokenizer(br.readLine());
		int num = arr.countTokens();
		
		for (int j = 0; j < num; j++) {
			int n = Integer.parseInt(arr.nextToken());		
			if ( n % 2 == 1)
				sum += n;
		}
		System.out.println("#" + (i) + " " + sum);
	}
}
}
