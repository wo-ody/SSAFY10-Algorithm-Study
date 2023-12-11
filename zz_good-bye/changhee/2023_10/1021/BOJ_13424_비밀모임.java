import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t= Integer.parseInt(br.readLine());
        for(int tc=0;tc<t; tc++){
            st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m =Integer.parseInt(st.nextToken());

            graph.clear();
            for(int i =0; i<n+1; i++) graph.add(new ArrayList<>());
            for(int i =0; i<m; i++){
                st=new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                int cost= Integer.parseInt(st.nextToken());
                graph.get(x).add(new Node(y,cost));
                graph.get(y).add(new Node(x,cost));
            }

            int k = Integer.parseInt(br.readLine());
            int[][] dist = new int[k][n+1];
            st=new StringTokenizer(br.readLine());
            for(int i =0; i<k; i++){
                int member = Integer.parseInt(st.nextToken());
                dijkstra(dist[i],member);
            }

            long minSum = Long.MAX_VALUE;
            int minIdx = -1;
            for(int i= 1; i<n+1; i++){
                long sum=0;
                for(int j = 0; j<k; j++){
                    sum += dist[j][i];
                }
                if(minSum > sum){
                    minSum = sum;
                    minIdx=i;
                }
            }
            answer.append(minIdx).append("\n");
        }
        System.out.println(answer);
    }

    public static void dijkstra(int[] dist, int start){
        PriorityQueue<Node> q= new PriorityQueue<>((o1, o2)->Integer.compare(o1.cost,o2.cost));

        Arrays.fill(dist,INF);
        dist[start] = 0;
        q.offer(new Node(start,0));

        while(!q.isEmpty()){
            Node node = q.poll();

            for(Node thisNode : graph.get(node.x)){
                if(dist[thisNode.x] > dist[node.x] + thisNode.cost){
                    dist[thisNode.x] = dist[node.x] + thisNode.cost;
                    q.offer(new Node(thisNode.x, dist[thisNode.x]));
                }
            }
        }
    }
    static class Node{
        int x,cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}
