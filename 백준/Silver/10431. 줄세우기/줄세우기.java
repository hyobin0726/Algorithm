// 카순서대로 줄세우기
// 첫번째 테스트케이스 수 P
// 케이스 번호 T, 20개 양의 정수
// 뒤로 물러난 횟수 구하기

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int p = Integer.parseInt(br.readLine());
        int[][] map = new int[p][22];
        List<Integer> list;

        int ans;
        for(int i=0; i<p; i++){
            list = new ArrayList<>();
            ans =0;
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<21; j++ ){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            list.add(map[i][1]);

            for(int j=2; j<21; j++){
                int tmp = list.size();
                for(int k=tmp-1; k>=0; k--){
                    if(map[i][j] < list.get(k)){
                        ans++;
                    }else {
                        break;
                    }
                }
                list.add(map[i][j]);
                Collections.sort(list);
            }
            System.out.println((i+1) + " " + ans);

        }

    }
}
