import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {
    static boolean[][] board;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        board = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i<e; i++){
            int startIdx = sc.nextInt();
            int endIdx = sc.nextInt();

            board[startIdx][endIdx] = true;
            board[endIdx][startIdx] = true;
        }

        int cnt = BFS(1);

        System.out.println(cnt);

    }

    public static int BFS(int idx){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;
        int cnt = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 1; i<board.length; i++){
                if(board[cur][i] && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
