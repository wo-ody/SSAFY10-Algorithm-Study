import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int INF=Integer.MAX_VALUE;
    static int[] route;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i =0; i<n+1; i++) graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y,cost));
            graph.get(y).add(new Node(x,cost));
        }

        route = new int[n+1];
        for(int i=1; i<n+1; i++) dijkstra(i,n);
        System.out.println(answer);
    }

    public static void dijkstra(int start, int n){
        PriorityQueue<Node> q= new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        int[] dist = new int[n+1];

        q.offer(new Node(start,0));
        Arrays.fill(dist,INF);
        Arrays.fill(route,0);
        dist[start] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            if(dist[node.x] < node.cost) continue;

            for(Node thisNode : graph.get(node.x)){
                if(dist[thisNode.x] > dist[node.x]+thisNode.cost){
                    route[thisNode.x] = node.x;
                    dist[thisNode.x] = dist[node.x]+thisNode.cost;
                    q.offer(new Node(thisNode.x,dist[thisNode.x]));
                }
            }
        }

        for(int i =1; i<n+1; i++){
            if(i==start) answer.append("- ");
            else answer.append(findRoute(i,start)).append(" ");
        }
        answer.append("\n");
    }

    public static int findRoute(int x,int start){
        if(route[x]==start) return x;
        return route[x] = findRoute(route[x],start);
    }

    static class Node{
        int x,cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}
