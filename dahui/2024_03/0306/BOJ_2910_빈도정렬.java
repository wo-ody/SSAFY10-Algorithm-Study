import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2910_빈도정렬 {
    //개수와 처음 나온 등수
    static HashMap<Integer, Node> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (map.containsKey(n)) {
                Node node = map.get(n);
                map.put(n, new Node(node.cnt+1, node.rank));
            }else {
                map.put(n, new Node(1, r++));
            }
        }

        List<Map.Entry<Integer, Node>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Node>>() {
            @Override
            public int compare(Map.Entry<Integer, Node> o1, Map.Entry<Integer, Node> o2) {
                if (o1.getValue().cnt == o2.getValue().cnt) return o1.getValue().rank - o2.getValue().rank;
                else return o2.getValue().cnt - o1.getValue().cnt;
            }
        });

        for (Map.Entry<Integer, Node> entry : list) {
            for (int i = 0; i < entry.getValue().cnt; i++) {
                sb.append(entry.getKey()).append(" ");
            }
        }
        System.out.println(sb);

    }
    public static class Node {
        int cnt;
        int rank;
        public Node(int cnt, int rank) {
            this.cnt = cnt;
            this.rank = rank;
        }
    }
}
