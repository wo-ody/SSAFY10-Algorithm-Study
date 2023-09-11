import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i =0;i<n+1; i++) graph.add(new ArrayList<>());
        for(int i =0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,cost));
        }

        st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int z=Integer.parseInt(st.nextToken());

        int xToy=dijkstra(x,y,0,n);
        int yToz=dijkstra(y,z,0,n);
        int xToz=dijkstra(x,z,y,n);

        System.out.printf("%d %d",(xToy==INF || yToz==INF)?-1:xToy+yToz,xToz==INF?-1:xToz);
    }

    public static int dijkstra(int start,int end,int jump, int n){
        PriorityQueue<Node> q= new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        int[] dist = new int[n+1];

        Arrays.fill(dist,INF);
        dist[start]=0;

        q.offer(new Node(start,0));
        while(!q.isEmpty()){
            Node node = q.poll();
            if(dist[node.x]<node.cost || node.x == jump) continue;

            for(Node thisNode : graph.get(node.x)){

                if(dist[thisNode.x]>dist[node.x]+thisNode.cost){
                    dist[thisNode.x]=dist[node.x]+thisNode.cost;
                    q.offer(new Node(thisNode.x,dist[thisNode.x]));
                }
            }
        }
        return dist[end];
    }

    static class Node{
        int x,cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}
