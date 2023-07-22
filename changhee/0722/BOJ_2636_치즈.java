/**
 * 7.22 김창희
 * BOJ_2636_치즈
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //0과
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time=0,count=0;
        while(true){
            int result = setFrame(map, n, m);
            if(result==0) break;
            time++;
            count=result;
        }

        System.out.println(time+"\n"+count);


    }

    public static int setFrame(int[][] map, int n, int m) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] v= new boolean[n][m];
        int result = 0;

        q.offer(new Node(0, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (!v[nx][ny] && map[nx][ny] == 0) {
                    v[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
                if (!v[nx][ny] && map[nx][ny] == 1) {
                    v[nx][ny] = true;
                    result++;
                    map[nx][ny] = 0;
                }
            }
        }
        return result;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
