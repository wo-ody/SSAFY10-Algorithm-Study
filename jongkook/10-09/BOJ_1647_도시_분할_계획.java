import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int vertex, edge;
    static int[] parent;
    static ArrayList<ArrayList<Node>> lst = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        for(int v = 0; v <= vertex; v++) lst.add(new ArrayList<>());


        parent = new int[vertex+1];

        for(int i = 0; i <= vertex; i++) parent[i] = i;
        for(int e = 0; e < edge; e++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lst.get(from).add(new Node(to, cost));
            lst.get(to).add(new Node(from, cost));
            pq.add(new Node(from,to, cost));
        }

        System.out.println(kruskal());
    }
    static int kruskal(){
        int res = 0;
        int max = 0;
        boolean[] visited = new boolean[vertex+1];
        while(!pq.isEmpty()){
            Node currentNode = pq.poll();

                if(union(currentNode.v, currentNode.e)) {
                    max = Math.max(max, currentNode.cost);

                    res += currentNode.cost;
                    visited[currentNode.v] = true;
                }
        }
        return res - max;
    }
    static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(find(aRoot) == find(bRoot)) return false;
        parent[bRoot] = aRoot;
        return true;
    }
    static class Node{
        int v,e, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public Node(int v, int e, int cost) {
            this.v = v;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", cost=" + cost +
                    '}';
        }
    }
}
