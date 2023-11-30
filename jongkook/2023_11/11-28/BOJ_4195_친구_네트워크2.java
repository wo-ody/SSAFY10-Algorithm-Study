import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main {
    static int[] parent; // 유니온 파인드 루트 노드 배열
    static int[] level; // 각 노드마다 층의 개수
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
 
            parent = new int[F * 2];
            level = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }
 
            int idx = 0;
            Map<String, Integer> map = new HashMap<>();
 
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
 
                if (!map.containsKey(a)) {
                    map.put(a, idx++);
                }
 
                if (!map.containsKey(b)) {
                    map.put(b, idx++);
                }
 
                sb.append(union(map.get(a), map.get(b)) + "\n");
            }
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
 
        return parent[x] = find(parent[x]);
    }
 
    // 합집합 연산
    public static int union(int x, int y) {
        x = find(x);
        y = find(y);
 
        // 항상 x < y인 값이 들어온다고 가정
        if (x != y) {
            parent[y] = x;
            level[x] += level[y]; // y에 있던 층의 개수를 더해 줌.
 
            // 어차피 y의 부모는 항상 x이므로 level[y]를 접근할 일은 없으므로 꼭 이렇게 초기화해 줄 필요는 없음.
            level[y] = 1;
        }
 
        return level[x];
    }
 
}
