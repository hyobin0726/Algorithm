import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int v, e;
	static class edge implements Comparable<edge>{
		int to, cost;

		public edge( int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
		
	}
	static ArrayList<edge>[] edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v= Integer.parseInt(st.nextToken());
		e= Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		edges = new ArrayList[v+1];
		for(int i=0; i<=v; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[s].add(new edge(e,c));
//			edges[e].add(new edge(s,c));
		}
		int[] mincost = new int[v+1];
		for(int i=0; i<=v; i++) {
			mincost[i] = Integer.MAX_VALUE;
		}
		mincost[start] = 0;
		PriorityQueue<edge> q = new PriorityQueue<>();
		q.add(new edge(start, 0));

		while(!q.isEmpty()) {
			edge now = q.poll();
			int a = now.to;
			if (now.cost > mincost[a]) continue;
			for(int i =0; i<edges[a].size();i++ ) {
				 edge next = edges[a].get(i);
				 if(mincost[next.to] > mincost[a] + next.cost) {
					 mincost[next.to] =  mincost[a] +next.cost;
					 q.add(new edge(next.to, mincost[next.to]));
				 }
			}
		}
		for(int i=1; i<=v; i++) {
			if(mincost[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(mincost[i]);
			}
		}
	}
	
}