import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static Map<Integer, Integer> map;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        while (true) {
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0) {
                System.out.println(sb);
                return;
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int temp = Integer.parseInt(st.nextToken());

                    if (map.containsKey(temp)) {
                        map.put(temp, map.get(temp) + 1);
                    } else {
                        map.put(temp, 1);
                    }
                }
            }

            List<Integer> keySet = new ArrayList<>(map.keySet());
            keySet.sort((e1, e2) -> map.get(e1).equals(map.get(e2)) ? e1 - e2 : map.get(e2) - map.get(e1));

            int second = map.get(keySet.get(1));

            for (Integer i : keySet) {
                if (map.get(i) > second)
                    continue;

                if (map.get(i) == second) {
                    sb.append(i).append(" ");
                } else {
                    break;
                }
            }
            sb.append("\n");
        }
    }
}