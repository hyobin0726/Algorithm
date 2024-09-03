import java.util.*;
import java.io.*;
public class Solution {
	static int n;
	static int[][] map;
	static int[] dx= {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        int tc = Integer.parseInt(br.readLine());
	        for (int test = 1; test <= tc; test++) {
	        	n = Integer.parseInt(br.readLine());
	        	map = new int[n][n];
	        	
	        	for(int i=0; i<n; i++) {
	        	 String str = br.readLine();
	        	 for(int j=0; j<n; j++) {
	        		 map[i][j] =(int) str.charAt(j)-'0';
	        	 	}
	        	}
	        	System.out.println("#" + test + " " + getmindistance(0, 0));
	        }
	 }
	 static int getmindistance(int r, int c) {
		 final int inf = Integer.MAX_VALUE;
		 boolean[][] visited = new boolean[n][n];
		 int[][] mintime = new int[n][n];
		 //행,열,시간 -> 시간이 최소인 것이 우선
		 PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
		 
		 for(int i=0; i<n; i++) {
			 for(int j=0;j<n; j++) {
				 mintime[i][j] = inf;
			 }
		 }
		 mintime[r][c] = 0;
		 pq.offer(new int[] {r,c,mintime[r][c]});
		 
		 while(!pq.isEmpty()) {
			 
			 int[] stopover =pq.poll();
			 int x= stopover[0];
			 int y = stopover[1];
			 int time = stopover[2];
			 
			 if(visited[x][y]) continue;
			 visited[x][y] = true;
			 
			 if(x == n-1 && y == n-1) return time;
			 
			 for(int d=0; d<4; d++) {
				 int nx = x + dx[d];
				 int ny = y + dy[d];
				 
				 if(0<= nx && nx<n && 0<= ny && ny<n && !visited[nx][ny] && mintime[nx][ny] > time+ map[nx][ny]) {
					 mintime[nx][ny] = time + map[nx][ny];
					 pq.offer(new int[] {nx, ny, mintime[nx][ny]});
				 }
			 }
		 }
		 return -1;
 	 }
}
