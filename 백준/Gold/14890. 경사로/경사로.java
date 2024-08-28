import java.util.*;
import java.io.*;
public class Main {
    static int n, l;
    static int[][] map;
//    static boolean[][] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        row();
        col();
        System.out.println(ans);



    }
    static void row(){
        for(int i=0; i<n; i++){
            int cnt = 1;
            boolean flag = true;
            for(int j=0; j<n-1; j++){
                //다음과 같은 높이
                if(map[i][j] == map[i][j+1]){
                    cnt++;
                }
                //높이가 1차이
                else if(map[i][j] == map[i][j+1]+1){
                    //경사로를 놓았을 때 범위를 벗어나면
                    if(j+l >= n){
                        flag = false;
                        break;
                    }
                    //같은 높이에 경사로를 놓을 수 있음을 확인
                    for(int k=1; k<=l; k++){
                        if(map[i][j+1] != map[i][j+k]){
                            flag = false;
                            break;
                        }
                    }
                    //경사로를 놓을 수 있으면
                    if(flag){
                        //경사로를 놓은 만큼 j를 증가시킴
                        j += l-1;
                        cnt = 0;
                    }

                }
                // 높이가 1차이
                else if(map[i][j] == map[i][j+1]-1){
                    //경사로보다 길이가 짧으면
                    if(cnt < l){
                        flag = false;
                        break;
                    }
                    cnt = 1;
                }
                //높이가 2이상 차이
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }
    }
    static void col(){
        for(int i=0; i<n; i++){
            int cnt = 1;
            boolean flag = true;
            for(int j=0; j<n-1; j++){
                //다음과 같은 높이
                if(map[j][i] == map[j+1][i]){
                    cnt++;
                }
                //높이가 1차이
                else if(map[j][i] == map[j+1][i]+1){
                    //경사로를 놓았을 때 범위를 벗어나면
                    if(j+l >= n){
                        flag = false;
                        break;
                    }
                    //
                    for(int k=1; k<=l; k++){
                        if(map[j+1][i] != map[j+k][i]){
                            flag = false;
                            break;
                        }
                    }
                    //경사로를 놓을 수 있으면
                    if(flag){
                        j += l-1;
                        cnt = 0;
                    }

                }
                // 높이가 1차이
                else if(map[j][i] == map[j+1][i]-1){
                    //경사로보다 길이가 짧으면
                    if(cnt < l){
                        flag = false;
                        break;
                    }
                    cnt = 1;
                }
                //높이가 2이상 차이
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }


    }
}
