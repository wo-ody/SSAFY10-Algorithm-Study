package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1. 위험한 구역과 죽음의 구역, 안전한 구역 위치 매핑하기
// 2. 위험한 공간의 가중치 1, 안전한 구역 가중치 0, 죽음의 공간은 갈 수 없도록 진행
// 3. 다익스트라 진행
public class BOJ_1584_게임 {
    static final int max_input= 501;
    // 0 일때 안전, 1 일때 위험, 2 일때 죽음
    // 값이 들어올 때 더 큰 값으로 겹치기
    static int[][] area = new int[max_input][max_input];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int dangerZone = Integer.parseInt(br.readLine());
        mapping(dangerZone, 1);

        int deathZone = Integer.parseInt(br.readLine());
        mapping(deathZone, -1);
        int res = dijkstra();
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);

    }
    static void mapping(int size,  int weight) throws IOException {
        for(int s = 0; s < size; s++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = Math.min(x1, x2); j <= Math.max(x1,x2); j++){
                for(int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++){
                    area[j][k] = weight;
                }
            }
        }
    }

    static int dijkstra(){

        PriorityQueue<Node> pq = new PriorityQueue<>((c1, c2) -> c1.cost - c2.cost);
        boolean[][] visited = new boolean[max_input][max_input];
        int[][] dist = new int[max_input][max_input];
        for(int i = 0; i < max_input; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        pq.add(new Node(0, 0, 0));
        dist[0][0] = 0;
        visited[0][0] = true;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            for(int d = 0; d < 4; d++){
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= max_input || nx >= max_input || visited[ny][nx] || area[ny][nx] == -1) continue;
                if(dist[ny][nx] > node.cost + area[ny][nx]){
                    dist[ny][nx] = node.cost + area[ny][nx];
                    visited[ny][nx] = true;
                    pq.add(new Node(ny, nx, dist[ny][nx]));
                }
            }
        }
//        print_map(dist);
        return dist[max_input-1][max_input-1];
    }

    private static void print_map(int[][] dist) {
        for(int i=0; i<max_input; i++){
            Arrays.stream(dist[i]).forEach(j-> System.out.print(j+" "));
            System.out.println();
        }
    }

    static class Node{
        int y, x, cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
