import java.io.*;
import java.util.*;
public class Main {
    static int n,m,k;
    static int[][] tree;
    static int[][] map;
    static int[][] A;
    //나무수
    static int result;
    static int[] dx ={-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        result = 0;
        A = new int[n][n];
        for (int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //각 나무 정보
        List<tree> trees = new ArrayList<>();
        List<tree> temp = new ArrayList<>();
        for (int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            trees.add(new tree(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),true));
        }

        //맵의 양분
        map =new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                map[i][j] = 5;
            }
        }
        for(int y=0; y<k;y++) {
            Collections.sort(trees);
            //봄
            //양분섭취
            result = trees.size();
            for(int i=0; i<result; i++){
                int tx = trees.get(i).x;
                int ty = trees.get(i).y;
                int tz = trees.get(i).z;

                if(map[tx][ty] >= tz){
                    map[tx][ty] -= tz;
                    trees.get(i).z += 1;
                }else {
                    trees.get(i).live = false;
                }
            }
            //여름
            for(int i=result-1; i>=0; i--){
                int tx = trees.get(i).x;
                int ty = trees.get(i).y;
                int tz = trees.get(i).z;
                //죽은거 섭취
                if(!trees.get(i).live){
                    map[tx][ty] += tz/2;
                }else {
                    temp.add(new tree(tx,ty,tz,true));
                }
            }
            trees.clear();
            trees.addAll(temp);
            temp.clear();

            result = trees.size();
            //가을
            for(int i=0; i<result; i++) {
                int tx = trees.get(i).x;
                int ty = trees.get(i).y;
                int tz = trees.get(i).z;
                //나이가 5의 배수
                if(tz%5==0){
                    for (int j = 0; j < 8; j++) {
                        int nx = tx + dx[j];
                        int ny = ty + dy[j];
                            if(0<= nx && nx<n && 0<=ny && ny<n ){
                                trees.add(new tree(nx,ny,1,true));
                            }
                        }
                }
            }

            //겨울
            for(int i=0; i<n;i++){
                for(int j=0; j<n;j++){
                    map[i][j] += A[i][j];
                }
            }

        }
        System.out.println(trees.size());

    }
     static class tree implements Comparable<tree>{
        int x,y,z;
        boolean live;

         public tree(int x, int y, int z, boolean live) {
             this.x = x;
             this.y = y;
             this.z = z;
             this.live = live;

         }
         @Override
         public int compareTo(tree o) {
             return Integer.compare(this.z,o.z);
         }
     }
}
