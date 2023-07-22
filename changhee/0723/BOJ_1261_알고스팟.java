/**
 * 7.23 김창희
 * BOJ_1261_알고스팟
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j)-48;
            }
        }
        //기존의 bfs를 이용하여 탐색을 할시 벽을 부수는 경우와 부수지 않는 경우를 나눠서 탐색을 한다면 시간복잡도가 커진다
        //다익스트라 개념을 이용하여 이동하고자 하는 위치까지의 최단거리만 큐에 offer하며 탐색을한다.
        int answer = dijkstra(map, m,n);
        System.out.println(answer);
    }

    private static int dijkstra(int[][] map, int n, int m) {
        PriorityQueue<Node> q= new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        int[][] dist = new int[n][m];

        q.offer(new Node(0,0,0));
        for(int i =0; i<n; i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[0][0] = 0;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i =0; i<4; i++){
                int nx= node.x+dx[i];
                int ny= node.y+dy[i];

                if(nx<0||ny<0||nx>=n||ny>=m) continue;

                if(dist[nx][ny] >map[nx][ny]+node.cost){
                    dist[nx][ny] =map[nx][ny]+node.cost;
                    q.offer(new Node(nx,ny,dist[nx][ny]));
                }
            }
        }

        return dist[n-1][m-1];
    }
    static class Node{
        int x,y,cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
