import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
    static int T, N;
    static int[][] board;
    static int[][] visited; // 이동횟수로 방문 체크

    static int sx, sy, ex, ey; // 시작좌표, 타겟 좌표

    static int[] dx = {-2, -1, -2, -1, 1, 2, 1, 2};
    static int[] dy = {-1, -2, 1, 2, -2, -1, 2, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 초기화
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            visited = new int[N][N];
            
            // 시작좌표
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            
            // 타겟 좌표
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            
            BFS();
            System.out.println(visited[ex][ey]);
        }
    }

    static void BFS() {
        Queue<Integer> queue = new ArrayDeque<>(); // x, y 순서대로 넣을 큐
        queue.offer(sx);
        queue.offer(sy);
        visited[sx][sy] = 0;
        while(!queue.isEmpty()){
            int curX = queue.poll();
            int curY = queue.poll();
            if(curX == ex && curY == ey){ // 만약 타겟에 도착하면 break;
                break;
            }
            for(int i = 0; i<8; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(canGo(nx, ny)){
                    queue.add(nx);
                    queue.add(ny);
                    visited[nx][ny] = visited[curX][curY]+1;
                }
            }
        }
    }

    static boolean canGo(int x, int y){
        if(x <0 || x>=N || y<0 || y>=N){
            return false;
        }
        if(visited[x][y]!= 0) return false;
        return true;
    }
}
