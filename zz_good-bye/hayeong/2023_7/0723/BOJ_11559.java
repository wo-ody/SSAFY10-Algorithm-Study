import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PuyoPuyo {

    static char[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static ArrayList<Node> list;
    static int n = 12, m = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new char[n][];
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            board[i] = tmp.toCharArray();
        }

        int count = 0;
        while (true) {
            boolean isFinished = true;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(board[i][j], i, j);

                        if (list.size() >= 4) {
                            isFinished = false;
                            for (int k = 0; k < list.size(); k++) {
                                board[list.get(k).x][list.get(k).y] = '.';
                            }
                        }
                    }
                }
            }
            if (isFinished) break;
            fallPuyos();
            count++;
        }
        System.out.println(count);
    }

    public static void fallPuyos() {
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j > 0; j--) {
                if (board[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[k][i] != '.') {
                            board[j][i] = board[k][i];
                            board[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void bfs(char c, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list.add(new Node(x, y));
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(canGo(nx, ny, c)){
                    visited[nx][ny] = true;
                    list.add(new Node(nx, ny));
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static boolean canGo(int x, int y, char c){
        if(x <0 || x>=n || y<0 || y>=m){
            return false;
        }
        if(visited[x][y]){
            return false;
        }
        if(board[x][y] != c){
            return false;
        }
        return true;
    }


    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


