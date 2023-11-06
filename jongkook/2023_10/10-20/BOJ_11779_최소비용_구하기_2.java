package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11779_최소비용_구하기_2 {
    static int vertex, edge, start, end, count;
    static ArrayList<ArrayList<Node>> lst = new ArrayList<>();
    static int[] dist, nextCity;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        // 2차원 그래프 생성
        for(int i = 0; i <= vertex; i++) lst.add(new ArrayList<>());

        for(int e = 0; e < edge; e++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lst.get(from).add(new Node(to, cost));

        }
        dist = new int[vertex+1];
        nextCity = new int[vertex+1];
        visited = new boolean[vertex+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();
        stack.addLast(end);
        while(nextCity[end] != 0){
            stack.addLast(nextCity[end]);
            end = nextCity[end];
        }
        System.out.println(stack.size());
        while(!stack.isEmpty()) System.out.print(stack.pollLast() + " ");
    }
    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int currentNumber = node.x;
            int currentCost = node.cost;

            if(visited[currentNumber] || dist[currentNumber] < currentCost) continue;
            visited[currentNumber] = true;

            for(Node elem : lst.get(currentNumber)){
                if(!visited[elem.x] && dist[elem.x] > currentCost + elem.cost){
                    sb.append(elem.x).append(" ");
                    dist[elem.x] = currentCost + elem.cost;
                    nextCity[elem.x] = currentNumber;
                    pq.offer(new Node(elem.x, currentCost + elem.cost));
                }
            }
        }
        System.out.println(dist[end]);
    }
    static class Node{
        int x, cost;

        public Node(int x, int cost) {
            super();
            this.x = x;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", cost=" + cost +
                    '}';
        }
    }
}
