package graph;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽_부수고_이동하기 {
    static int vertex, edge;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        int[][] map = new int[vertex][edge];
        int[][][] visited = new int[vertex][edge][2];

        for (int i = 0; i < vertex; i++) {
            String line = br.readLine();
            for (int j = 0; j < edge; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0, 1, 0 }); // x, y, distance, isBroken
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            int isBroken = current[3];

            if (x == vertex - 1 && y == edge - 1) {
                System.out.println(distance);
                return;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < vertex && ny >= 0 && ny < edge) {
                    if (visited[nx][ny][isBroken] == 0) {
                        if (map[nx][ny] == 0) {
                            queue.add(new int[] { nx, ny, distance + 1, isBroken });
                            visited[nx][ny][isBroken] = 1;
                        } else {
                            if (isBroken == 0) {
                                queue.add(new int[] { nx, ny, distance + 1, 1 });
                                visited[nx][ny][1] = 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
