import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[m][n][h];
        int ans =0;
        for(int i=0; i< h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    tomato[k][j][i]= Integer.parseInt(st.nextToken());
                }

            }
        }

        int[] dx = {1,-1,0,0,0,0};
        int[] dy = {0,0,1,-1,0,0};
        int[] dz = {0,0,0,0,1,-1};

        Queue<int[]> q= new LinkedList<>();

        boolean is= false;
        for(int i=0; i< h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(tomato[k][j][i] == 1){
                        q.add(new int[] {k,j,i});
                    }else if(tomato[k][j][i] == 0){
                        is =true;
                    }
                }

            }
        }

        if(q.isEmpty()){
            if(is) {
                System.out.println("-1");
                 return;
            }
            System.out.println(ans);
            return;
        }

        while (!q.isEmpty()){
            int[] tmp =q.poll();

            for(int i=0; i<6; i++){
                int tx = tmp[0] + dx[i];
                int ty= tmp[1] + dy[i];
                int tz = tmp[2] + dz[i];
                if(0<= tx && tx <m && 0<= ty && ty <n && 0<= tz && tz <h){
                    if(tomato[tx][ty][tz] == 0 ){
                        tomato[tx][ty][tz] = tomato[tmp[0]][tmp[1]][tmp[2]] +1;
                        q.add(new int[] {tx,ty,tz});
                    }
                }
            }
        }
        for(int i=0; i< h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(tomato[k][j][i] == 0){
                        System.out.println("-1");
                        return;
                    }else {
                        ans = Math.max(ans, tomato[k][j][i]);
                    }
                }

            }
        }
        System.out.println(ans-1);

    }
}
