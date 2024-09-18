import java.util.*;
import java.io.*;

public class Main {
    static HashMap<String, String> parent;
    static HashMap<String, Integer> size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int f = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            size = new HashMap<>();
            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                
                // 초기화: 각 사람이 처음 등장하면 자신을 부모로 설정하고 크기는 1로 설정
                if (!parent.containsKey(a)) {
                    parent.put(a, a);
                    size.put(a, 1);
                }
                if (!parent.containsKey(b)) {
                    parent.put(b, b);
                    size.put(b, 1);
                }

                // 두 사람을 하나의 네트워크로 합치고, 그 네트워크의 크기를 출력
                union(a, b);
                System.out.println(size.get(find(a))); // a가 속한 네트워크 크기를 출력
            }
        }
    }

    // find 함수는 루트 노드를 반환하고, 경로 압축을 통해 최적화
    static String find(String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x))); // 경로 압축
        }
        return parent.get(x);
    }

    // union 함수는 두 네트워크를 합침, 크기를 올바르게 업데이트
    static void union(String x, String y) {
        x = find(x); // x의 루트 노드를 찾음
        y = find(y); // y의 루트 노드를 찾음
        
        // 만약 루트가 다르면 두 네트워크를 합침
        if (!x.equals(y)) {
            // 크기가 더 작은 트리를 큰 트리 아래로 붙이기
            if (size.get(x) < size.get(y)) {
                parent.put(x, y); // x의 루트가 y로 변경
                size.put(y, size.get(y) + size.get(x)); // y 트리의 크기 갱신
            } else {
                parent.put(y, x); // y의 루트가 x로 변경
                size.put(x, size.get(x) + size.get(y)); // x 트리의 크기 갱신
            }
        }
    }
}
