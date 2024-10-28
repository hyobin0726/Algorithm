import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<int[]> egg;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		egg = new LinkedList<>();
		visited = new boolean[n];
		ans = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			egg.add(new int[] { a, b });

		}
		dfs(0, visited);
		System.out.println(ans);

	}

	static void dfs(int idx, boolean[] visited) {
		if (idx == n) {
			int temp = 0;
//			System.out.println(Arrays.toString(visited));
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					temp++;
				}
			}
			if (ans < temp) {
				ans = temp;
			}

			return;
		}

		for (int i = 0; i < n; i++) {
			boolean isflag = false;
			if (i == idx)
				continue;
			if (!visited[i] && !visited[idx]) {
				crack(idx, i);
				isflag = true;
			}
			dfs(idx + 1, visited);
			if (isflag) {
				revert(idx, i);
			}
		}
	}

	static void crack(int idx, int temp) {
		int a1 = egg.get(idx)[0];
		int a2 = egg.get(idx)[1];

		int b1 = egg.get(temp)[0];
		int b2 = egg.get(temp)[1];

		if (a1 - b2 <= 0) {
			egg.get(idx)[0] = a1 - b2;
			visited[idx] = true;
		} else {
			egg.get(idx)[0] = a1 - b2;
		}

		if (b1 - a2 <= 0) {
			egg.get(temp)[0] = b1 - a2;
			visited[temp] = true;
		} else {
			egg.get(temp)[0] = b1 - a2;
		}
	}

	static void revert(int idx, int temp) {

		int a1 = egg.get(idx)[0];
		int a2 = egg.get(idx)[1];

		int b1 = egg.get(temp)[0];
		int b2 = egg.get(temp)[1];

		if (a1 <= 0) {
			egg.get(idx)[0] += b2;
			visited[idx] = false;
		} else {
			egg.get(idx)[0] += b2;
		}

		if (b1 <= 0) {
			egg.get(temp)[0] += a2;
			visited[temp] = false;
		} else {
			egg.get(temp)[0] += a2;
		}
	}
}