import java.util.*;
import java.io.*;

public class Main {
    static int n,c;
    static int[] home;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        c =Integer.parseInt(st.nextToken());
        home = new int[n];
        for(int i=0; i<n; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        max= Integer.MIN_VALUE;
        binary();
        System.out.println(max);

    }
    static void binary() {
        int start = 0;
        int end = home[n-1] - home[0];
        int mid=0;

        while (start<=end){
            //각 공유기 설치 집간 간격
            mid = (start+end)/2;
            //가장 첫번째 집 공유기 설치
            int temp = home[0];
            //공유기 설치 갯수
            int cnt =1;
            for(int i=1; i<n; i++){
                if(home[i] - temp >=mid){
                    temp = home[i];
                    cnt++;
                }
            }
//            System.out.println(cnt);

            if (cnt >= c){
                max = Math.max(max,mid);
                start = mid+1;
            }
            else if(cnt<c){
                end = mid-1;
            }
            else if(cnt > c){
                start = mid+1;
            }
        }
    }
}