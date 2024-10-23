import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int a;
    static int b ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n= Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited= new boolean[n][n];
        a=0;
        b=0;
        for(int i =0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j] =='B'){
                    a++;
                    bfs('B', ' ',i,j);
                }
                if(!visited[i][j] && map[i][j] =='R'){
                    a++;
                    bfs('R',' ',i,j);
                }
                if(!visited[i][j] && map[i][j] =='G'){
                    a++;
                    bfs('G', ' ', i,j);
                }
            }
        }
        visited= new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j] =='B'){
                    b++;
                    bfs('B', ' ',i,j);
                }
                if(!visited[i][j] && (map[i][j] =='R' || map[i][j] =='G') ){
                    b++;
                    bfs('R','G',i,j);
                }

            }
        }
        System.out.println(a + " "+ b );

    }
    static void bfs(char value,char value2 ,int x,int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        visited[x][y] = true;

        while (!q.isEmpty()){
            int[] temp = q.poll();
            int  tx = temp[0];
            int ty = temp[1];

            for(int i=0; i<4; i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(0<= nx && nx<n && 0<= ny && ny<n){
                    if(!visited[nx][ny] && (map[nx][ny] == value || map[nx][ny] == value2 )){
                        visited[nx][ny] = true;
                        q.add(new int[] {nx,ny});
                    }
                }

            }

        }


    }
}