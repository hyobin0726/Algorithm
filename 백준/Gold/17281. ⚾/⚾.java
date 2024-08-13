import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static boolean[] visited = new boolean[9];
    static int[] arr = new int[9];
    static int[][] player ;
    static int result = Integer.MIN_VALUE;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        player = new int[n][10];
        for (int j = 0; j <n ; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<10 ; i++ ){
                player[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        arr[3] = 1; // 4번 타자를 1번 선수로 고정
        visited[3] = true;

        order(2);

        System.out.println(result);
    }
    //자리 정하기
    static void order(int temp) {
        cnt=0;

        if (temp == 10){
            int cnt = game();
            if (cnt> result ) {
                result =cnt;
            }
            return;

        }

        for (int i =0; i<9 ; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[i] = temp;
                order(temp+1);
                visited[i] = false;
            }

        }

    }
    //게임
    static int game() {
        int sum = 0;
        int idx=0;
        int out;

        for (int i =0; i< n; i++) {
            int temp =0;
            out = 0;
            boolean[] base = new boolean[4];

            while(out < 3) {
                if(idx>=9){
                    idx = idx%9;
                }

                switch (player[i][arr[idx]]) {
                    case 1 :{
                        if (base[3]) {
                            temp += 1;
                            base[3] = false;
                        }
                        if (base[2]) {
                            base[2] = false;
                            base[3] = true;
                        }
                        if (base[1]) {
                            base[1] = false;
                            base[2] = true;
                        }
                        base[1] = true;
                        break;
                    } case 2 : {
                        if (base[3]) {
                            temp += 1;
                            base[3] = false;
                        }
                        if (base[2]) {
                            temp += 1;
                            base[2] = false;

                        }
                        if (base[1]) {
                            base[1] = false;
                            base[3] = true;
                        }
                        base[2] = true;
                        break;
                    } case 3: {
                        if (base[3]) {
                            temp += 1;
                            base[3] = false;
                        }
                        if (base[2]) {
                            temp += 1;
                            base[2] = false;

                        }
                        if (base[1]) {
                            temp += 1;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;
                    } case 4: {
                        if (base[3]) {
                            temp += 1;
                            base[3] = false;
                        }
                        if (base[2]) {
                            temp += 1;
                            base[2] = false;

                        }
                        if (base[1]) {
                            temp += 1;
                            base[1] = false;
                        }
                        temp += 1;
                        break;
                    } case 0: {
                        out++;
                        break;
                    }

                }
                idx++;
        }
            sum += temp;
    }
        return sum;
    }
}
