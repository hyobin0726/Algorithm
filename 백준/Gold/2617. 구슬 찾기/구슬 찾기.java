import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] light;
	static int[][] heavy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		light = new int[n + 1][n + 1];
		heavy = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			light[a][b] = 1;
			heavy[b][a] = 1;

		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if( i==j) continue;
					if(light[i][k] ==1 && light[k][j]==1) {
						light[i][j] =1;
					}
					if(heavy[i][k] ==1 && heavy[k][j]==1) {
						heavy[i][j] =1;
					}
				} 
			}
		}

		int ans=0;
		int cnt = n/2+1;
		for(int i=1; i<=n; i++) {
			int temp1 =0;
			int temp2 =0;
			for(int j=1; j<=n; j++) {
				if(light[i][j] ==1) {
					temp1++;
				}
				if(heavy[i][j] ==1) {
					temp2++;
				}
			}
			if(cnt<=temp1 || cnt<=temp2) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}