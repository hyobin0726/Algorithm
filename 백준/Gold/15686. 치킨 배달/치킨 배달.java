import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int[][] arr ;
	static List<int[]> temp = new ArrayList<>();
	static List<int[]> two = new ArrayList<>();
	static List<int[]> home = new ArrayList<>();
	static List<Integer> result = new ArrayList<>();

 	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 n = Integer.parseInt(st.nextToken());
		 m= Integer.parseInt(st.nextToken());
		 arr = new int[n][n];
		 
		 for (int i =0; i<n;i++) {
			 StringTokenizer str = new StringTokenizer(br.readLine());
			 for (int j =0; j<n;j++) {
				 arr[i][j] =Integer.parseInt(str.nextToken());
				 if (arr[i][j] == 2) {
					 temp.add(new int[] {i,j});
				 }else if (arr[i][j] ==1) {
					 home.add(new int[] {i,j});
				 }
			 }
		 }
		 
		 for (int i = 1; i< m+1; i++ ) {
			dfs(0, i); 
		 }
		 System.out.println(Collections.min(result));
	
 	}
 	static void dfs(int start, int count) {
 		if (two.size() == count) {
 			
 			chicken(two);
 			return;
 			}
 		for (int i = start; i <temp.size(); i++ ) {
 			if(!two.contains(temp.get(i))) {
 				two.add(temp.get(i));
 				dfs(i+1, count);
 				two.remove(temp.get(i));
 		}
 	}
 }

    static void chicken(List<int[]> ch) {
        int total = 0;

        for (int[] h : home) {
            int h_x = h[0];
            int h_y = h[1];
            int minDist = Integer.MAX_VALUE;

            for (int[] c : ch) {
                int c_x = c[0];
                int c_y = c[1];
                int dist = Math.abs(h_x - c_x) + Math.abs(h_y - c_y);

                if (dist < minDist) {
                    minDist = dist;
                }
            }
            total += minDist;
        }
        result.add(total);
    }
}
