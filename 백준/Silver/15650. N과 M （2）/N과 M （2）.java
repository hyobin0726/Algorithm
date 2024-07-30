import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static List<Integer> arr = new LinkedList<>();
	static int start;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dfs(1);
	
	}
	static void dfs(int start) {
		if (arr.size() == m) {
			for (int num : arr) {
				System.out.print(num+ " ");
			}
			System.out.println();
			return;
		}
		for (int i =start; i < n+1; i++) {
			if (!arr.contains(i)) {
				arr.add(i);
				dfs(i+1);
				arr.remove((Integer)i);
			}
			
		}
	}
}
