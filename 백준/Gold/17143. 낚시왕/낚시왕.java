import java.io.*;
import java.util.*;
public class Main {
    static int R,C,M;
   //상어체크
    static class shark{
        int r,c,s,d,z;

       public shark(int r, int c, int s, int d, int z) {
           this.r = r;
           this.c = c;
           this.s = s;
           this.d = d;
           this.z = z;
       }
   }
    static shark[][] map;
    static List<shark> sharks;
    static int ans;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new shark[R+1][C+1];


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new shark(r,c,s,d,z);
        }
        ans = 0;
        int cnt =0;
        //게임 시작(낚시왕이동)
        for(int t=1; t<=C; t++){
            //상어잡기
            for(int i=1; i<=R; i++){
                if(map[i][t] != null){
                    ans += map[i][t].z;
                    cnt++;
                    map[i][t] = null;
                    break;
                }
            }

            //낚시할 상어 체크
            if(cnt == M){
                System.out.println(ans);
                return;
            }
            sharks = new ArrayList<>();
            //살아있는 상어만 담기
            for(int i=1; i<=R; i++){
                for(int j=1; j<=C; j++){
                    if(map[i][j] != null){
                        sharks.add(new shark(map[i][j].r,map[i][j].c,map[i][j].s,map[i][j].d,map[i][j].z));
                    }
                }
            }
            //살아있는 상어가 없다면 체크
            if(sharks.size() ==0){
                System.out.println(ans);
                return;
            }
            //맵 다시 정의
            map = new shark[R+1][C+1];

            //상어 이동
            for(int i=0; i<sharks.size(); i++){
                shark temp = sharks.get(i);
                //시간초과로 인한 크기수정
                    int time = temp.s;
                    if(temp.d ==1 || temp.d ==2){
                        time %= (R-1)*2;
                     }else {
                        time %= (C-1)*2;
                    }
                    for(int a=0; a<time;a++){//크기만큼 이동
                        int nx = temp.r + dx[temp.d-1];
                        int ny = temp.c + dy[temp.d-1];
                        if(0< nx && nx<=R && 0<ny && ny<=C){
                            temp.r = nx;
                            temp.c = ny;
                        }else {
                            if(temp.d ==1){
                                temp.d=2;
                            }else if(temp.d ==2){
                                temp.d=1;
                            }else if(temp.d ==3){
                                temp.d=4;
                            }else if(temp.d ==4){
                                temp.d=3;
                            }
                            nx = temp.r + dx[temp.d-1];
                            ny = temp.c + dy[temp.d-1];
                            temp.r = nx;
                            temp.c = ny;
                        }
                    }

                    //크기싸움
                    if(map[temp.r][temp.c] == null){
                        map[temp.r][temp.c] =  new shark(temp.r,temp.c,temp.s,temp.d,temp.z);
                    }else {
                        if(map[temp.r][temp.c].z < temp.z){
                            map[temp.r][temp.c] =  new shark(temp.r,temp.c,temp.s,temp.d,temp.z);
                        }
                }
            }



        }
        System.out.println(ans);

    }
}