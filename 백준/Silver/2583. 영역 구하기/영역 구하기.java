import java.io.*;
import java.util.*;

public class Main {
	static int m;
	static int n;
	static int k;
	static int[][] graph;
	static boolean[][] visited;
 	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int cnt;
	static List<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		m = Integer.parseInt(st.nextToken());
		n =Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		graph = new int[m][n];
		visited = new boolean[m][n];
		cnt = 0;
		
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			ice(a,b,c,d);
			
		}
		
		for (int i = 0; i<m; i++) {
			for (int j =0; j<n; j++) {
				if(graph[i][j] == 0 && !visited[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		System.out.println(cnt);
		result.sort(null);
		
		for(int i=0; i<result.size(); i++) {
			sb.append(result.get(i) + " ");
		}
		System.out.println(sb);
		
		
	}
	static void ice(int x1, int y1, int x2, int y2) {
		for (int i = y1; i<y2; i++) {
			for (int j = x1; j<x2; j++) {
				graph[i][j] = 1;
			}
		}
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		int area=0;
		
		
		q.add(new int[] {x,y});
		visited[x][y] = true; 
		area++;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int tx = temp[0];
			int ty = temp[1];
			
			for(int i=0; i<4; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				
				if( 0<=nx && nx<m && 0<= ny && ny<n) {
					if(!visited[nx][ny] && graph[nx][ny] ==0) {
						visited[nx][ny] = true;
						area++;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		result.add(area);
	}
}
