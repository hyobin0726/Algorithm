import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String game;
        int ans;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        game = st.nextToken();

        HashSet<String> name = new HashSet<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            name.add(tmp);
        }
        if(game.equals("Y")){
            System.out.println(name.size());
        }else if (game.equals("F")) {
            System.out.println(name.size()/2);
        } else if (game.equals("O")) {
            System.out.println(name.size()/3);
        }

    }
}
