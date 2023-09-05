import java.util.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int count = 0;
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};


    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < pos.length; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && graph[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        boolean zero = true;
        List<Integer> answer = new ArrayList<>();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 1) {
                    zero = false;
                }
            }
        }

        if(zero == true) {
            System.out.println("0");
            System.out.println("0");
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 0; //////////////////// 1
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        System.out.println(answer.get(answer.size() - 1));
    }
}
