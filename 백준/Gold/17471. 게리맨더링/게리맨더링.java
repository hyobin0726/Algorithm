import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] people;
	static ArrayList<Integer>[] list;
	static boolean[] group;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		ans= Integer.MAX_VALUE;
		group = new boolean[n + 1];
		dfs(group, 1);
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}

	}

	static void dfs(boolean[] group, int depth) {
		if (depth == n + 1) {
			visited = new boolean[n + 1];
//			System.out.println(Arrays.toString(group));
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					bfs(i, group[i]);
					cnt++;
				}
//				System.out.println(Arrays.toString(visited));
			}

//			System.out.println(cnt);
			if (cnt == 2) {
				int a =0;
				int b=0;
				for(int i=1; i<=n; i++) {
					if(group[i]) {
						a += people[i];
					}else {
						b+= people[i];
					}
				}
				ans = Math.min(ans, Math.abs(a-b));
			}
			return;
		}

		for (int i = depth; i <= n; i++) {
			group[i] = true;
			dfs(group, i + 1);
			group[i] = false;
		}
	}

	static void bfs(int x, boolean value) {
		Queue<Integer> q = new LinkedList<>();
		visited[x] = true;
		q.add(x);

		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < list[temp].size(); i++) {
				int ntemp = list[temp].get(i);

				if (!visited[ntemp] && group[ntemp] == value) {
					visited[ntemp] = true;
					q.add(ntemp);

				}
			}
		}
	}
}