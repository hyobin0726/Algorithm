import java.util.*;
import java.io.*;
public class Solution {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int t = Integer.parseInt(br.readLine());
        for(int test=1; test<t+1; test++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            int n = Integer.parseInt(st.nextToken());
            parent = new int[n+1];
            for (int i=1; i<n+1; i++) {
                parent[i] = i;
            }
            int m = Integer.parseInt(st.nextToken());
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (op == 0) {
                    // union
                    int parentA = getParent(a);
                    int parentB = getParent(b);
                    if(a<b ) {
                        parent[parentB] = parentA;
                    } else {
                        parent[parentA] = parentB;
                    }
                } else {
                    // find
                    int parentA = getParent(a);
                    int parentB = getParent(b);
                    if(parentA == parentB) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            System.out.println("#"+test+" "+ sb.toString());
        }
    }
    static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

}
