package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1167_트리의_지름 {
    static int V;

    static class Node{
        int idx, cost;
        Node(int idx,int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        // 트리에서 하나의 노드에서 가장 먼 정점은 해당 트리에서의 가장 긴 구간 중 하나
        // 하나를 찾고, 다른 하나를 탐색

//        int[][] graph = new int[V + 1][V + 1];
        graph = new ArrayList<>();
        for(int i = 0 ; i < V+1; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
//            graph.add();
            while (nextNode != -1) {
                int cost = Integer.parseInt(st.nextToken());
                graph.get(node).add(new Node(nextNode,cost));
                graph.get(nextNode).add(new Node(node,cost));
//                graph[node][nextNode] = cost;
//                graph[nextNode][node] = cost;

                nextNode = Integer.parseInt(st.nextToken());
            }

            // 입력 완료
            // 임의의 하나의 노드에서 가장 먼 노드를 찾자

        }
        int[] tmp = bfs(1);
        tmp = bfs(tmp[0]); // 이러면 지름이 tmp[1]에 담길 것

        System.out.println(tmp[1]);

    }

    static int[] bfs(int root) { // return값이 가장 먼 노드임
        Queue<Integer> queue = new ArrayDeque<>();
        // 만약 시간초과가 나면 map을 arrayList로 바꾸자
        int[] visited = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            visited[i] = -1;//초기화
        }
        visited[root] = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int nNode = queue.poll();

            for(Node i: graph.get(nNode)){
                if (visited[i.idx] == -1){
                    visited[i.idx] = visited[nNode] + i.cost;
                    queue.offer(i.idx);
                }
            }
//            for (int i = 1; i < V + 1; i++) {
////                if (graph.get(nNode).)
//                if (graph[nNode][i] != 0 && visited[i] == -1) { // 아직 방문 x
//                    visited[i] = visited[nNode] + graph[nNode][i]; // 방문처리
//                    queue.offer(i);
//
//                }
//            }

        }

        // 끝나면 다른 노드들 까지의 거리가 나와 있을 거임
        // 그럼 그 중 가장 큰 노드를 찾아
        int maxCost = -1;
        int maxIdx = -1;
        for (int i = 1; i < V + 1; i++) {
            if (visited[i] > maxCost) {
                maxCost = visited[i];
                maxIdx = i;
            }
        }

        // 이제 가장 먼 노드를 발견했으니 다시 여기서부터 진행해야겠다.
        return new int[]{maxIdx, maxCost};
    }
}
