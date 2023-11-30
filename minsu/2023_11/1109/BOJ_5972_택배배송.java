import java.util.*;
 
public class Main {
    
    static int n, m;
    static int[] dist;
    static ArrayList<Node>[] list;
    static boolean[] visited;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
        m = scan.nextInt();
 
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            int cost = scan.nextInt();
            list[s].add(new Node(e, cost));
            list[e].add(new Node(s, cost));
        }
 
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, 50000001); //50000 * 1000 + 1
        dijkstra();
        System.out.println(dist[n]); //목적지는 n
    }
 
    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[1] = 0; //시작 지점은 1
        q.offer(new Node(1, 0));
 
        while(!q.isEmpty()) {
            Node current = q.poll();
 
            if(!visited[current.d]) visited[current.d] = true;
            else continue;
 
            for(int i = 0; i < list[current.d].size(); i++) {
                Node next = list[current.d].get(i);
                if(dist[next.d] > dist[current.d] + next.cost) {
                    dist[next.d] = dist[current.d] + next.cost;
                    q.offer(new Node(next.d, dist[next.d]));
                }
            }
        }
    }
 
    public static class Node implements Comparable<Node> {
        int d;
        int cost;
 
        public Node(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
