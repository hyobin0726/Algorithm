import java.io.*;
import java.util.*;
public class Main {
	static int n;

	static LinkedList<Integer>[] graph;
	static int[] degree;
	static int[] time;
	static int[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =Integer.parseInt(br.readLine());
		graph = new LinkedList[n+1];
		for(int i=0; i<=n; i++) {
			graph[i] = new LinkedList<>();
		}
		degree = new int[n+1];
		time = new int[n+1];
		result= new int[n+1];
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			time[i] = temp;
			while(temp != -1) {
				temp = Integer.parseInt(st.nextToken());
				if(temp != -1) {
					graph[temp].add(i);
					degree[i]++; 
				}
			}
		}
		Queue<Integer> q= new LinkedList<>();
		for(int i=1; i<=n;i++) {
			if(degree[i]==0) {
				q.add(i);
				result[i] = time[i];
			}
		}
	
		
		while(!q.isEmpty()) {
			int temp = q.poll();

//			degree[temp]--;
			for(int i=0; i<graph[temp].size(); i++) {
				int child = graph[temp].get(i);
				degree[child]--;
				result[child] = Math.max(result[temp]+time[child],result[child]); 
				if (degree[child] == 0) {
                    q.add(child);
                }
			}
			
//			for(int i=1; i<=n; i++) {
//				if(degree[i] == 0) {
//					q.add(i);
//				}
//			}
		}
		for(int i=1; i<=n; i++) {
			System.out.println(result[i]);
		}
	}

}