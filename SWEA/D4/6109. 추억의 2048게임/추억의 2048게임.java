import java.io.*;
import java.util.*;
public class Solution {
	static int n;
	static String s;
	static int[][] graph;
	static int[][] result;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int test=1; test<t+1;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			s = st.nextToken();
			
			graph = new int[n][n];
			result = new int[n][n];
			
			
			for (int i=0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<n;j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				
				}
			}
	
			switch (s) {
			case "up": {
				for (int i =0; i <n; i++) {
					for (int j=0; j<n-1; j++) {	
						if(graph[j][i]==0) {
							for(int k=j+1; k<n; k++) {
								if(graph[k][i] == 0) {
									continue;
								}
								else {
									graph[j][i] = graph[k][i];
									graph[k][i]=0;
									break;
								}	
							}
												
						}
					}					
				}
				
				for (int i =0; i <n; i++) {
					cnt=0;
					for (int j=0; j<n-1; j++) {
						if(graph[j][i] == graph[j+1][i]){
							graph[j][i] = graph[j][i]+graph[j+1][i];
							graph[j+1][i] = 0;
							
						}
						if(graph[j][i]>0) {
							result[cnt][i] = graph[j][i];
							cnt++;
						}
					}
					if(graph[n-1][i]>0) {
						result[cnt][i] = graph[n-1][i];
						cnt++;
					}
				}	
			
			}
			break;
			case "down" :{
				for (int i =n-1; i >=0; i--) {
					for (int j=n-1; j >=0; j--) {	
						if(graph[j][i]==0) {
							for(int k=j-1; k>=0; k--) {
								if(graph[k][i] == 0) {
									continue;
								}
								else {
									graph[j][i] = graph[k][i];
									graph[k][i]=0;
									break;
								}	
							}
												
						}
					}					
				}
				
				for (int i =n-1; i>=0; i--) {
					cnt=n-1;
					for (int j=n-1; j-1>=0; j--) {
						if(graph[j][i] == graph[j-1][i]){
							graph[j][i] = graph[j][i]+graph[j-1][i];
							graph[j-1][i] = 0;
							
						}
						if(graph[j][i]>0) {
							result[cnt][i] = graph[j][i];
							cnt--;
						}
					}
					if(graph[0][i]>0) {
						result[cnt][i] = graph[0][i];
						
					}
				}
			}
			break;
			case "left" : {
				for (int i =0; i <n; i++) {
					for (int j=0; j<n; j++) {	
						if(graph[i][j]==0) {
							for(int k=j+1; k<n; k++) {
								if(graph[i][k] == 0) {
									continue;
								}
								else {
									graph[i][j] = graph[i][k];
									graph[i][k]=0;
									break;
								}	
							}
												
						}
					}					
				}
				
				for (int i =0; i <n; i++) {
					cnt=0;
					for (int j=0; j<n-1; j++) {
						if(graph[i][j] == graph[i][j+1]){
							graph[i][j] = graph[i][j]+graph[i][j+1];
							graph[i][j+1] = 0;
							
						}
						if(graph[i][j]>0) {
							result[i][cnt] = graph[i][j];
							cnt++;
						}
					}
					if(graph[i][n-1]>0) {
						result[i][cnt] = graph[i][n-1];
						cnt++;
					}
				}
			}
			break;
			case "right" : {
				for (int i =n-1; i >=0; i--) {
					for (int j=n-1; j>=0; j--) {	
						if(graph[i][j]==0) {
							for(int k=j-1; k>=0; k--) {
								if(graph[i][k] == 0) {
									continue;
								}
								else {
									graph[i][j] = graph[i][k];
									graph[i][k]=0;
									break;
								}	
							}
												
						}
					}					
				}
				
				for (int i =n-1; i >=0; i--) {
					cnt=n-1;
					for (int j=n-1; j>0; j--) {
						if(graph[i][j] == graph[i][j-1]){
							graph[i][j] = graph[i][j]+graph[i][j-1];
							graph[i][j-1] = 0;
							
						}
						if(graph[i][j]>0) {
							result[i][cnt] = graph[i][j];
							cnt--;
						}
					}
					if(graph[i][0]>0) {
						result[i][cnt] = graph[i][0];
				
					}
				}
			}
		
			
			}
			System.out.println("#"+test);
			for (int i=0; i<n;i++) {
				for (int j=0; j<n;j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}

		}
	}
}

