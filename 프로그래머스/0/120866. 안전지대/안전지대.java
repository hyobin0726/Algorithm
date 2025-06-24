import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        answer = board.length*board.length;
        List<int[]> points = new ArrayList<>();
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board.length; j++){
                if(board[i][j] ==1){
                    points.add(new int[]{i, j});
                }
            }
        }
        int[] dx= {-1,0,1,-1,1,-1,0,1};
        int[] dy={1,1,1,0,0,-1,-1,-1};
        for(int i=0; i < points.size(); i++){
            int x = points.get(i)[0];
            int y = points.get(i)[1];
            for(int j=0; j<8; j++){
                int a= x+dy[j];
                int b = y+dx[j];
                if(0<=a && a< board.length && 0<= b && b< board.length ){
                    board[a][b] = 1;
                }
            }
       
        }
        int cnt=0;
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board.length; j++){
                if(board[i][j] ==1){
                    cnt++;
                }
            }
        }
        answer -= cnt;
        return answer;
    }
}