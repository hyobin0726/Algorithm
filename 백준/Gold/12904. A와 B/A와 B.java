import java.util.*;
import java.io.*;

public class Main {
    static String s;
    static String t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        while (t.length() > s.length()) {

            if (t.substring(t.length() - 1).equals("B")) {
                t = new StringBuilder(t.substring(0, t.length() - 1)).reverse().toString();
            }
            else if (t.substring(t.length() - 1).equals("A")) {
                t= t.substring(0, t.length() - 1);
            }

        }
        if(t.equals(s)){
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }

    }

}