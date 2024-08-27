import java.io.*;
import java.util.*;
public class Solution {
	static int n;
	static Character[][] graph;
	static boolean[][] visited;
	static ArrayList<int[]> zero = new ArrayList<>();
	static int[][] number;
	static int[] dx = {0,0,1,-1,-1,-1,1,1};
	static int[] dy = {1,-1,0,0,-1,1,-1,1};
	static int total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int test=1; test<t+1; test++) {
			n = Integer.parseInt(br.readLine());
			graph = new Character[n][n];
			visited = new boolean[n][n];
			number = new int[n][n];
			total=0;
			for(int i =0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<n; j++) {
					graph[i][j] = str.charAt(j);
					
				}
			}
			for(int i =0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(graph[i][j].equals('*') ){
						number[i][j] = -1;
						num(i, j);
					}
					
				}
			}
		
	
			for(int i =0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(number[i][j] == 0 && !visited[i][j]) {
						pang(i,j);
					}
					
				}
			}
			
			for (int i =0; i < n; i++) {
				for (int j=0; j<n; j++) {
					if(number[i][j] != -1 && visited[i][j] == false) {
						visited[i][j] = true;
						total+=1;
					}
				}
			}
			System.out.println("#" + test + " "+ total);
		}
		
	}
	static void num(int x, int y) {
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (0<=nx && nx <n && 0<= ny && ny<n) {
				if (number[nx][ny] != -1 ) {
					number[nx][ny] +=1;
				}
			}
		}
		return;
	}
	static void pang(int x, int y) {
		total+=1;
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int tx = temp[0];
			int ty = temp[1];
			for(int i=0; i<8; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				
				if (0<=nx && nx <n && 0<= ny && ny<n) {
					if(number[nx][ny] == 0 && visited[nx][ny] == false) {
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny});
						
					}
					else if (number[nx][ny] != -1 ) {
						visited[nx][ny] = true;
					}
				}
			}
			
			
			
		}
		
	}

}
