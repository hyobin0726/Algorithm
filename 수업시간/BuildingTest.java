//2008 빌딩건설
import java.io.*;

public class BuildingTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int l = 0; l < t; l++) {
            int n = Integer.parseInt(br.readLine());

            String[][] arr = new String[n][n];

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");

                for (int j = 0; j < n; j++) {
                    arr[i][j] = line[j];

                }
            }
            int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
            int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
            int nx = 0;
            int ny = 0;

            int sum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int green = 0;
                    if (arr[i][j].equals("B")) {

                        for (int k = 0; k < 8; k++) {
                            nx = j + dx[k];
                            ny = i + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (arr[ny][nx].equals("G")) {
                                    green = 2;
                                    break;

                                }
                            }
                        }
                        if (green == 0){
                            for (int m=0; m<n; m++) {
                                if (arr[m][j].equals("B")){
                                    green +=1;
                                }
                                if (arr[i][m].equals("B")){
                                    green +=1;
                                }
                            }
                            green-=1; //자기자신 중복제거
                        }

                    }
                    if (sum < green) {
                        sum = green;
                    }
                }
            }
            System.out.println("#"+ (l+1) + " " + sum);
        }


    }
}