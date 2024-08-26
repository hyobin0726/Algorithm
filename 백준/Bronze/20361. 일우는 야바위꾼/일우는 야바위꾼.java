import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int x = Integer.parseInt(st.nextToken());
	int k = Integer.parseInt(st.nextToken());
	
	int[] arr = new int[n+1];
	for (int i = 1; i<n+1; i++) {
		arr[i] = i;
	}
	
	for (int i = 0; i<k; i++) {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	for(int j=1; j<n+1; j++) {
		if(arr[j] == x) {
			System.out.println(j);
			break;
		}
	
	
	
}
	
	
	
	
}
}
