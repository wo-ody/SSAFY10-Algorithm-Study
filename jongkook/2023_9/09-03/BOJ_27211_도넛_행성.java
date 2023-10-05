package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_27211_도넛_행성 {
    static int N, M , count, donut[][];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        donut = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                donut[i][j] =  Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(donut[i][j] == 0){
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    static void bfs(int col, int row){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(col, row));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;
            for(int dir = 0; dir <4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N && donut[ny][nx] == 0){
                    donut[ny][nx] = 1;
                    queue.offer(new Node(ny, nx));
                }
                else if(nx < 0 || ny < 0 || nx >= M || ny >= N){
                    if (nx < 0) nx = M - 1;
                    else if (nx > M - 1) nx = 0;

                    if (ny < 0) ny = N - 1;
                    else if (ny > N - 1) ny = 0;

                    if(donut[ny][nx] == 0){
                        donut[ny][nx] = 1;
                        queue.offer(new Node(ny, nx));
                    }

                }
//                if(nx < 0 || ny < 0 || nx >= M || ny >= N || donut[ny][nx] == 1){
//                    if(nx == 0 || ny == 0 || nx == M-1 || ny == N-1) {
//                        if (nx == 0) nx = M - 1;
//                        else if (nx == M - 1) nx = 0;
//
//                        if (ny == 0) ny = N - 1;
//                        else if (ny == N - 1) ny = 0;
//
//                        donut[ny][nx] = 1;
//                        queue.offer(new Node(ny, nx));
//                    }
//                }

//                if(nx == 0 || ny == 0 || nx == M-1 || ny == N-1){
//                    if(nx == 0) nx = M-1;
//                    else if (nx == M-1) nx = 0;
//
//                    if(ny == 0) ny = N-1;
//                    else if(ny == N-1) ny = 0;
//
//                    donut[ny][nx] = 1;
//                    queue.offer(new Node(ny, nx));
//                }



            }
        }
    }
    static class Node{
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
