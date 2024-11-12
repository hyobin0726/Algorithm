import java.io.*;
import java.util.*;
public class Main {
	static int n,m;
	static int[] degree;
	static ArrayList<Integer>[] list;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		degree = new int[n+1];
		list = new ArrayList[n+1];
		ans = new int[n+1];
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			degree[e]++;
			list[s].add(e);
		}
//		System.out.println(Arrays.toString(degree));
		for(int i=1; i<=n; i++) {
			if(degree[i] ==0) {
				degree[i]--;
				ans[i]++;
				q.add(new int[] {i,1});
			}
		}
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int tx = temp[0];
			int tcnt = temp[1];
			for(int i=0; i<list[tx].size(); i++) {
				degree[list[tx].get(i)]--;
				if(degree[list[tx].get(i)] ==0) {
					degree[list[tx].get(i)]--;
					ans[list[tx].get(i)] = tcnt+1;
					q.add(new int[] {list[tx].get(i), tcnt+1});
				}
			}

		}
		
		for(int i=1; i<=n; i++) {
			System.out.print(ans[i] + " ");		
		}	
	}

}