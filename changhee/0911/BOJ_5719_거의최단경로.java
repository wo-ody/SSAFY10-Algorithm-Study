/*
 *  09.11 김창희
 *  BOJ_5719_거의최단경로
 *
 *  [풀이]
 *  1. 다익스트라를 구하며 x->y로 갈때가 최단 경로이면 리스트에 그 정보를 추가한다.
 *  2. 최단 경로 리스트를 재귀를 통해 역추적하며 최소 비용이 나온 경로는 방문배열로 true처리한다.
 *  3. 한번더 다익스트라를 수행하며 최소비용일때와 방문배열이 false일때를 만족하는 거의최단경로를 구한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Integer>> removePoint= new ArrayList<>();
    static boolean[][] v;
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        while(true) {
            st=new StringTokenizer(br.readLine());
            int n =Integer.parseInt(st.nextToken());
            int m =Integer.parseInt(st.nextToken());

            if(n==0&&m==0) break;

            st=new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.clear();
            removePoint.clear();
            v=new boolean[n][n];
            for(int i =0; i<n; i++) {
                graph.add(new ArrayList<>());
                removePoint.add(new ArrayList<>());
            }

            for(int i =0; i<m; i++) {
                st=new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                int cost= Integer.parseInt(st.nextToken());
                graph.get(x).add(new Node(y,cost));
            }

            dijkstra(start,end, n);
            checkRoute(end, start);
            int result = dijkstra(start,end, n);
            answer.append(result==INF?-1:result).append("\n");
        }

        System.out.println(answer);

    }

    public static int dijkstra(int start, int end, int n) {
        PriorityQueue<Node> q= new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        q.offer(new Node(start,0));
        dist[start]=0;

        while(!q.isEmpty()) {
            Node node = q.poll();

            if(dist[node.x]<node.cost) continue;

            for(Node thisNode : graph.get(node.x)) {
                if(dist[thisNode.x]>dist[node.x]+thisNode.cost && !v[thisNode.x][node.x]) {
                    removePoint.get(thisNode.x).clear();
                    removePoint.get(thisNode.x).add(node.x);
                    dist[thisNode.x]=dist[node.x]+thisNode.cost;
                    q.offer(new Node(thisNode.x,dist[thisNode.x]));

                }else if(dist[thisNode.x]==dist[node.x]+thisNode.cost&& !v[thisNode.x][node.x]) {
                    removePoint.get(thisNode.x).add(node.x);
                }
            }
        }
        return dist[end];


    }

    public static void checkRoute(int x,int start) {
        if(x==start) {
            return;
        }
        for(int nx: removePoint.get(x)) {
            if(v[x][nx]) continue;
            v[x][nx] = true;
            checkRoute(nx, start);
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
