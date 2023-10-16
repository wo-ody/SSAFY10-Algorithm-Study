import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
//바이러스 객체
class virus {
    int y;
    int x;
 
    public virus(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
 
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int result = Integer.MIN_VALUE;
    static int[] x = {1, -1, 0, 0}, y = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s1[j]);
            }
        }
        dfs(0);
 
        System.out.println(result);
    }
 
    public static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
 
    public static void bfs() {
        int[][] virus_map = new int[N][M];
        Queue<virus> queue = new ArrayDeque<>();
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus_map[i][j] = map[i][j];
            }
        }
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_map[i][j] == 2) {
                    queue.add(new virus(i, j));
                }
            }
        }
 
        while (!queue.isEmpty()) {
            virus poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll.y + y[i];
                int nx = poll.x + x[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
                    if (virus_map[ny][nx] == 0) {
                        virus_map[ny][nx] = 2;
                        queue.add(new virus(ny, nx));
                    }
                }
            }
        }
        count(virus_map);
    }
 
    public static void count(int[][] virus_map) {
        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_map[i][j] == 0) {
                    temp++;
                }
            }
        }
        result = Math.max(result, temp);
    }
}
