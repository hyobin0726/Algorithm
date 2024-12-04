import java.io.*;
import java.util.*;
//0인 좌표 저장
//가로 확인 -> 세로 확인 -> 9칸 확인 후 모두 가능하다면 다음 진행
//가로,세로,9칸 배열을 모두 확인 후 백트래킹 진행(중요)
//0 리스트 사이즈와 채운 칸의 수가 같다면 출력

public class Main {
    static int[][] map;
    static List<int[]> zero;
    static boolean end;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //변수 초기화
        map = new int[10][10];
        zero = new ArrayList<>();
        end= false;

        //입력
        for(int i=1; i<=9; i++){
            String str = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j+1]= str.charAt(j)-'0';
                if(map[i][j+1] ==0){
                    zero.add(new int[] {i,j+1});
                }
            }
        }
        game(0);

    }
    static void game(int check){
        if(end){
            return;
        }
        if(check== zero.size()){
//            System.out.println("end");
            for(int i=1; i<=9; i++){
                for(int j=1; j<=9; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            end = true;
            return;
        }

        boolean[] num = new boolean[10];

        int x = zero.get(check)[0];
        int y = zero.get(check)[1];
//        System.out.println(x+ " " + y);
        //가로
        for(int i=1;i<=9; i++){
            if(map[x][i] !=0){
                num[map[x][i]] = true;
            }
        }
        //세로
        for(int i=1; i<=9; i++){
            if(map[i][y] != 0){
                num[map[i][y]] = true;
            }
        }
        //3*3배열
        int row = (y-1)/3*3+1;
        int col = (x-1)/3*3+1;

        for(int i = col; i<col+3; i++){
            for(int j = row; j<row+3; j++){
                if(map[i][j] != 0){
                    num[map[i][j]] = true;
                }
            }
        }
        for(int i=1; i<=9; i++){
            if(!num[i]){
                map[x][y] = i;
                game(check+1);
                map[x][y] = 0;
            }
        }

    }

}