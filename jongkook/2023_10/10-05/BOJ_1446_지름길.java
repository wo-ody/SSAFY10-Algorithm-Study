package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
    static int tc, destination;
    static PriorityQueue<Integer> pq;
    static int[] dist;
    static Node[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tc = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        dist = new int[destination + 1];
        for(int i = 1; i <= destination; i++ ) dist[i] = destination;

        graph = new Node[tc];

        for(int t = 0; t < tc; t++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[t] = new Node(from, to, cost);
        }
        dijkstra();
        System.out.println(dist[destination]);
    }
    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.stop - n2.stop);
        pq.offer(new Node(0, 0, 0));
        dist[0] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            for(Node road : graph){
                if(node.stop > destination) continue;
                if(dist[road.stop] > dist[node.stop] + road.stop + road.start - node.stop){
                    dist[road.stop] = dist[node.stop] + road.stop + road.start - node.stop;
                    // 현재의 stop 값이 다음 번의 start, 다음 번의 stop 값, 다음 번의 도착지
                    pq.offer(new Node(node.stop, road.stop, dist[road.stop]));
                }
            }
        }
    }

    static class Node{
        int start, end, stop;

        public Node(int start, int end, int stop) {
            this.start = start;
            this.end = end;
            this.stop = stop;
        }
    }
}
