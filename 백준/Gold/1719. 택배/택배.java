import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m= Integer.parseInt(st.nextToken());
	int[][] arr = new int[n+1][n+1];
	int[][] start = new int[n+1][n+1];
	for(int i=1; i<=m; i++) {
		st = new StringTokenizer(br.readLine());
		int s= Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arr[s][e] = c;
		arr[e][s] =c;
		 start[s][e] = e;  // 처음에는 목적지를 직접 경유함
         start[e][s] = s;
	}
	
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=n; j++) {
			if(arr[i][j] == 0 && i!=j) {
				arr[i][j] = 1000001;
			}
		}
	}
	
	
	
	for(int k=1; k<=n; k++) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j]> arr[i][k] + arr[k][j]) {
					arr[i][j] = arr[i][k] + arr[k][j];
					start[i][j] = start[i][k]; 
				}
		
				
			}
		}
	}
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=n; j++) {
			if( i ==j) { 
				System.out.print("- " );
			}
			else {
			System.out.print(start[i][j] + " ");
		}
	}
		System.out.println();
	}
	
	}
}