import java.io.*;
import java.util.*;

public class Main {
	static int[] num = new int[9];
	static int[] result = new int[7];
	static int sum ;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<9; i++) {
			int input = Integer.parseInt(br.readLine());
			num[i] =input; 
		}

		hat(0, result, 0);
		
		
	}
	static void hat(int cnt, int[] result , int idx) {
		sum=0;
		if(cnt == 7) {
			for(int i = 0; i <7; i++) {
				sum+=result[i];
			}
			if (sum == 100) {
				for(int i = 0; i <7; i++) {
					System.out.println(result[i]);
				}
			}
			return;
		}
		for(int i=idx ; i<9; i++)
		{		
			result[cnt]= num[i];
			hat(cnt+1, result, i+1 );
		}
	}

}
