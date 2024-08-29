import java.io.*;
import java.util.*;
public class Solution {
	static ArrayList<Integer>[] arr;
	static int[] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t=1; t<11; t++) { 
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
		
			st = new StringTokenizer(br.readLine());
			arr = new ArrayList[101];
			visited = new int[101];
			for (int i=0; i<=100; i++) {
				arr[i] = new ArrayList<>();
			}
			for(int i=0; i<n/2; i++) {
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				arr[from].add(to);
			}
			bfs(start);
			System.out.println("#" + t + " " +ans);
			
			
			
		}
}
	
	
	static void bfs(int x) {
		int temp;
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = 1;
		ans = x;
		
	
		while(!q.isEmpty()) {
			temp = q.poll();
			if(visited[ans] < visited[temp]|| (visited[ans] == visited[temp]&& ans <temp) ){
				ans = temp;
			}
			
			for(int i=0; i< arr[temp].size(); i++) {
				if(visited[arr[temp].get(i)] ==0) {
					visited[arr[temp].get(i)]  =visited[temp]+1;
					q.add(arr[temp].get(i));
				}
			}
			
			
		}

		
	}
	
}