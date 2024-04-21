package algorithm2024.feb.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    //방향벡터 dy, dx 상 우 하 좌 순
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    //행의 개수 N, 열의 개수 M, N*M 맵
    static int N, M, map[][];

    //방문처리 boolean 배열, N*M*2
    static boolean[][][] v;

    //
    static int ans = -1;

    static class Node {
        int y, x, l;
        boolean isBreak;

        public Node(int y, int x, int l, boolean isBreak) {
            this.y = y;
            this.x = x;
            this.l = l;
            this.isBreak = isBreak;
        }

    }

    static boolean isValid(Node node) {
        int y = node.y;
        int x = node.x;

        if (y < 0 || x < 0 || y >= N || x >= M)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, false));
        v[0][0][0] = true;

        while (!q.isEmpty()) {

            Node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int l = cur.l;
            if (y == N - 1 && x == M - 1) {
                ans = l;
                break;
            }
            boolean isBreak = cur.isBreak;
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                Node next = new Node(ny, nx, l + 1, isBreak);
                if (!isValid(next))
                    continue;
                if (map[ny][nx] == 1 && !isBreak && !v[ny][nx][1]) {
                    v[ny][nx][1] = true;
                    next.isBreak = true;
                    q.offer(next);
                } else if (map[ny][nx] == 0) {
                    if (isBreak) {
                        if (v[ny][nx][1])
                            continue;
                        v[ny][nx][1] = true;
                    } else {
                        if (v[ny][nx][0])
                            continue;
                        v[ny][nx][0] = true;
                    }
                    q.offer(next);
                }
            }
        }
        System.out.println(ans);

    }
}