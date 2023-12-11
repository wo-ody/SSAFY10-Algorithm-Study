/*
 *  08.26 김창희
 *  swea_1767_프로세서_연결하기
 *
 *  [풀이]
 *  1. 코어의 좌표를 저장하는 리스트를 만들어 코어를 저장한다. 이때 코어가 벽에 붙어 있으면 최소거리 0이 보장되므로 리스트에 넣지않는다.
 *  2. 코어를 상하좌우중 한 방향으로 연결가능한지 판단하고 연결가능 하면 방문배열에 경로를 true로 변경하고 다음 코어로 연결시도한다.
 *  3. 모든 코어를 탐색했으면 함수를 종료하고 방문배열에 표시한 경로를 false로 변경 후, 다른 방향도 탐색하여 재귀적으로 모든 경우를 탐색한다.
 *
 *  [주의]
 *  코어마다 연결가능하면 바로 연결하는 것이 아니라, 현재 코어를 연결하지 않고 다음 코어를 연결하는 경우도 따져줘야한다.
 *  10개중 최대 8개 코어가 연결가능하다고 했을때,
 *  바로바로 연결하여 8개를 연결하는것보다
 *  현재 코어는 연결하지 않고 다른 코어부터 연결하여 8개를 연결하였을때 비용이 더 작을 수도 있다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int n, result, maxCount;
    static int[][] map;
    static boolean[][] line;
    static List<Node> core = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            line = new boolean[n][n];
            core.clear();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        if(i!=0&&j!=0) core.add(new Node(i, j));
                        line[i][j] = true;
                    }
                }
            }

            maxCount = 0;
            result = Integer.MAX_VALUE;
            install(0, 0, 0);

            answer.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    public static void install(int x, int len, int count) {
        if (x == core.size()) {
            if (count == maxCount) {
                result = Math.min(result, len);
            } else if (count > maxCount) {
                maxCount = count;
                result = len;
            }
            return;
        }

        Node node = core.get(x);
        install(x + 1, len, count);

        for (int i = 0; i < 4; i++) {
            if (isPossibleConnect(node, i)) {
                int temp = connect(node, i);
                install(x + 1, len + temp, count + 1);
                disConnect(node, i);
            }
        }

    }

    public static int connect(Node node, int dir) {
        int nx = node.x, ny = node.y, len = 0;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            line[nx][ny] = true;
            len++;
        }
        return len;
    }

    public static void disConnect(Node node, int dir) {
        int nx = node.x, ny = node.y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            line[nx][ny] = false;
        }
    }

    public static boolean isPossibleConnect(Node node, int dir) {
        int nx = node.x, ny = node.y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
            if (line[nx][ny]) return false;
        }
        return true;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
