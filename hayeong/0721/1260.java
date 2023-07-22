import java.util.*;
//1260
public class DFS와BFS {
    static boolean[][] board;
    static boolean[] visited;
    static int v, e, start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        start = sc.nextInt();

        board = new boolean[1001][1001];

        for (int i = 0; i < e; i++) {
            int startIdx = sc.nextInt();
            int endIdx = sc.nextInt();

            board[startIdx][endIdx] = true;
            board[endIdx][startIdx] = true;
        }

        visited = new boolean[v + 1];
        DFS(start);
        System.out.println();

        visited = new boolean[v + 1];
        BFS(start);
        System.out.println();

    }

    public static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i <= board.length - 1; i++) {
            if (board[start][i] && !visited[i]) {
                DFS(i);
            }
        }
    }
    static void BFS(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;
        System.out.print(start+" ");
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i < board.length; i++) {
                if (board[cur][i] == true && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
