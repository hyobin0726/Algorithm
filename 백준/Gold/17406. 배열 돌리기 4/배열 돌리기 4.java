import java.io.*;
import java.util.*;
public class Main {
	static int n,m,k;
	static int[][] map;
	static int[][] order;
	static int[][] copy;
	static int[] arr;
    static boolean[] check;
    static int ans;
    
 	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m =  Integer.parseInt(st.nextToken());
		k =  Integer.parseInt(st.nextToken());
		map = new int[n][m];
		copy = new int[n][m];
		arr = new int[k];
		check= new boolean[k];
		ans = Integer.MAX_VALUE;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				copy[i][j]=map[i][j];
				
			}
		}
		order = new int[k][3];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
	
			order[i][0] = r;
			order[i][1] = c;
			order[i][2] = s;
		}
		p(0);
		System.out.println(ans);
}
 	//순서정하기
 	static void p(int cnt) {
 		if(cnt==k) {
 			rotate(arr);
 			return;
 		}
 		for(int i=0; i<k; i++) {
 			if(!check[i]) {
 				check[i] = true;
 				arr[cnt] = i;
 				p(cnt+1);
 				check[i]= false;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
 			}
 		}
 	}
 	//회전하기
 	static void rotate(int[] select) {
 		int[][] temp = new int[n][m];
// 		temp = map.clone();
 		for(int i=0; i<n; i++) {
 			for(int j=0; j<m; j++) {
 				temp[i][j] = map[i][j];
 				copy[i][j] = map[i][j];
 			}
 			
 		}
  		for (int i=0; i<k; i ++) {
 			int r= order[select[i]][0];
 			int c = order[select[i]][1];
 			int s = order[select[i]][2];
 			
 			int startx = r-s-1;
 			int starty= c-s-1;
 			int endx = r+s-1;
 			int endy = c+s -1;
 			int count = Math.min(endx-startx, endy-starty)/2;
 			
 			for(int j =0; j < count; j++) {
 				//위 (>)
 				for(int k = endy-j; k> starty+j; k--) {
 					temp[startx+j][k] = copy[startx+j][k-1];
 				}
 				
 				//아래
 				for(int k = starty+j; k< endy-j; k++) {
 					temp[endx-j][k] = copy[endx-j][k+1];
 				}
 				//왼쪽
 				for(int k= startx+j; k<endx-j; k++) {
 					temp[k][starty+j]= copy[k+1][starty+j];
 				}
 				
 				//오른쪽
 				for(int k=endx-j; k>startx+j ; k--) {
 					temp[k][endy-j] = copy[k-1][endy-j];
 				}
 				
 			}
 			for(int a=0; a<n; a++) {
 	 			for(int b=0; b<m; b++) {
 	 				copy[a][b] = temp[a][b];
 	 			}
 			}
// 			copy=temp.clone();
 			
 		}
// 		copy=map.clone();
 		min(temp);
 		
 	}
 	
 	//최소값 구하기
 	static void min(int[][] result) {
 		for(int i=0; i<n; i++) {
 			int sum = 0;
 			for(int j=0; j<m; j++) {
 				sum+= result[i][j];
 			}
 			if(ans>sum) {
 				ans = sum;
 			}
 		}
 	}
}