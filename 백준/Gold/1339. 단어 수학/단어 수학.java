import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] words = new int[26];
        for (int i =0 ; i< n; i++){
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++){
                Character c= str.charAt(j);
                words[c - 65] += Math.pow(10, str.length() - j - 1);
            }

        }
        Arrays.sort(words);
        int sum = 0;
        int idx = 9;
        for (int i = 25; i>= 15; i--){
            sum += words[i] * idx;
            idx--;
        }
        System.out.println(sum);

    }
}
