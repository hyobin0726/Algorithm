import java.io.*;
import java.util.*;
public class Solution {
	static int n;
	static int[][] graph;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int max;
	static int min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int test=1; test < t+1; test++) {
			n =  Integer.parseInt(br.readLine());
			graph = new int[n][n];
			StringTokenizer st;
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int i=0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<n;j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				
				}
			}
			int temp=0;
			
			for(int i =0; i<n; i++) {
				for(int j =0; j<n ; j++) {
					temp = square(i,j, graph[i][j]);
					if(temp >max) {
						max =temp;
						min = graph[i][j];
						
					}else if (temp == max) {
						if (graph[i][j] <min) {
							min = graph[i][j];
						}
					}
				}
			}
			System.out.println("#"+ test + " " + min + " " + max);
			
		}
	}
	static int square(int x, int y, int num) {
		int cnt = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y, num});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int tx= temp[0];
			int ty = temp[1];
			int tnum = temp[2];
			
			for(int i=0; i<4;i++) {
				int nx = tx+ dx[i];
				int ny = ty + dy[i];
				
				if (0<=nx && nx<n && 0<= ny && ny<n) {
					if(graph[nx][ny] == tnum+1) {
						q.add(new int[] {nx,ny,graph[nx][ny] });
						++cnt;
					}
				}
			}
			
			
		}
		return cnt;
		
	}
}
