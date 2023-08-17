package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17836_공주님을구해라 {
    static int T,N,M;
    static int[][] map;
    static int[][] visited;
    static Node sword;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) sword = new Node(i,j,0);
            }
        }

        visited = new int[N][M];
        int result1 = noSword();

        sword.distance = visited[sword.x][sword.y];
        visited = new int[N][M];
        int result2 = yesSword();

        if(result1 == -1 && result2 == -1) System.out.println("Fail");
        else if(result1 == -1) System.out.println(result2);
        else if(result2 == -1) System.out.println(result1);
        else System.out.println(Math.min(result1, result2));

    }

    // 제한시간
    static int noSword() {
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(0,0));
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            if(visited[cur.x][cur.y] - 1 > T ) continue; // T 보다 클 경우
            if(cur.x == N-1 && cur.y == M-1) break;

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] != 0 || map[nx][ny] == 1) continue;
                if(visited[cur.x][cur.y] <= T) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                }
            }
        }

        return visited[N-1][M-1] - 1;

    }

    static int yesSword() {
        Queue<Node> queue = new ArrayDeque<>();

        if(sword.distance == 0) return -1; // 시작점에서 검까지 갈 수 없다는 의미

        queue.add(new Node(sword.x,sword.y));
        visited[sword.x][sword.y] = sword.distance;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            if(visited[cur.x][cur.y] - 1 > T ) continue; // T 보다 클 경우
            if(cur.x == N-1 && cur.y == M-1) break;

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] != 0) continue;
                if(visited[cur.x][cur.y] <= T) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                }
            }
        }

        return visited[N-1][M-1] - 1;
    }

    static class Node{
        int x,y,distance;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

}
