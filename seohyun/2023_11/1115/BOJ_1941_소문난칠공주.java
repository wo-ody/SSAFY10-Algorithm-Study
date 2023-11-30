import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static char[][] classroom;
    static int ans;
    static boolean[] visited;
    static int[] checked = new int[7];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        classroom = new char[5][5];
        for (int i = 0; i < 5; i++) {
            classroom[i] = br.readLine().toCharArray();
        }

        comb(0, 0, 0);
        System.out.println(ans);
    }


    static void comb(int cnt, int start, int dasomCnt) {
        if (cnt - dasomCnt > 3) return;

        if (cnt == 7) {
            visited = new boolean[7];
            bfs(checked[0]/5, checked[0]%5);
            return;
        }

        for (int i = start; i < 25; i++) {
            int row = i/5, col = i%5;
            checked[cnt] = i;
            comb(cnt+1, i+1, (classroom[row][col] == 'S')? dasomCnt+1: dasomCnt);
        }

    }


    static void bfs(int i, int j) {
        int num = 1;
        visited[0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] rowCol = queue.poll();
            int r = rowCol[0], c = rowCol[1];
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir], nc = c + dc[dir];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                int nxt = 5*nr + nc;
                for (int k = 0; k < 7; k++) {
                    if (!visited[k] && checked[k] == nxt) {
                        visited[k] = true;
                        num++;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
        }
        if (num == 7) ans++;
    }
}
