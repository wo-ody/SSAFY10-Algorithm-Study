import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node> graph = new ArrayList<>();
    static long INF = Long.MAX_VALUE;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph.clear();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Node(x, y, cost));
        }

        dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1]=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node node = graph.get(j);

                if (dist[node.x] != INF && dist[node.y] > dist[node.x] + node.cost) {
                    dist[node.y] = dist[node.x] + node.cost;

                    if(i==n-1){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int i =2; i<n+1; i++) {
            answer.append(dist[i]==Long.MAX_VALUE?-1:dist[i]).append("\n");
        }
        System.out.println(answer);
    }

    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

    }
}
