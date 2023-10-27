import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs
// K <= 몇번 사용했는지, visit 추가 관리
public class Main {

    static int K, W, H;
    static int[][] map;
    static boolean[][][] visit; // K가 추가됨

    // 상하좌우
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };

    // 격자 말
    static int[] hdy = { -2, -2, -1, -1, 2, 2, 1, 1 };
    static int[] hdx = { 1, -1, 2, -2, 1, -1, 2, -2 };

    // 큐
    static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visit = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        bfs();

    }

    static void bfs() {
        // 시작좌표 처리
        visit[0][0][K] = true;
        queue.offer(new Node(0, 0, K, 0));

        // queue가 빌때까지 bfs탐색
        // 한점에서 다음 이동을 고려할떄
        // #1. 사방탐색으로 갈 수 있는 곳을 찾아서queue에 담는다.
        // #2. 격자 말처럼 갈 수 있는 곳을 찾아서 queue에 담는다.(아직 K만큼 다 쓰지 않았으면 => 말처럼 가면 K감소 처리)
        // queue에서 꺼낸 노드가 오른쪽 맨 아래 좌표에 도달하면 성공(d 출력)
        // queue에서 모두 꺼내고 처리했는데도 도달 X => -1 출력

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // 목표도달 체크
            if (node.y == H - 1 && node.x == W - 1) {
                System.out.println(node.d);
                return;
            }

            // #1 상하좌우
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k])
                    continue;
                visit[ny][nx][node.k] = true;
                queue.offer(new Node(ny, nx, node.k, node.d + 1)); // 말 격자로 이동 X => K는 그대로
            }
            
            // #2. 말 격자
            if(node.k == 0) continue; // 이미 K를 모드 사용했으면 skip
            // 말-격자-8방
            for (int i = 0; i < 8; i++) {
                int ny = node.y + hdy[i];
                int nx = node.x + hdx[i];
                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 
                        || visit[ny][nx][node.k-1])
                    continue;
                visit[ny][nx][node.k-1] = true;
                queue.offer(new Node(ny, nx, node.k-1, node.d + 1)); // 말 격자로 이동 X => K는 그대로
            }
            
            
        }
        System.out.println(-1);
    }

    static class Node {
        int y, x, k, d;

        Node(int y, int x, int k, int d) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.d = d;
        }
    }

}
