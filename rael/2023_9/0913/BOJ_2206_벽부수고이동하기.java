import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ_2206_벽부수고이동하기 {
    static class Loc{
        int x;
        int y;
        int cnt;
        boolean destroyed;

        public Loc(int y, int x, int cnt, boolean d) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.destroyed = d;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }


        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 1, false));

        int[] mi = {0, 0, -1, 1};
        int[] mj = {-1, 1, 0, 0};

        boolean[][][] visited = new boolean[n][m][2];

        while (!q.isEmpty()) {
            Loc now = q.poll();

            if (now.y == n - 1 && now.x == m - 1) {
                System.out.println(now.cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ni = now.y + mi[d];
                int nj = now.x + mj[d];

                if(ni<0 || ni>=n || nj<0 || nj>=m) continue;

                int next_cnt = now.cnt+1;

                if(map[ni][nj]=='0'){ // 벽이 아니면
                    if(!now.destroyed && !visited[ni][nj][0]) { // 부신 벽이 여태까지 없었으면
                        q.add(new Loc(ni, nj, next_cnt, false));
                        visited[ni][nj][0] = true;
                    }else if(now.destroyed && !visited[ni][nj][1]){ // 벽을 한번 부신 적이 있으면
                        q.add(new Loc(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }

                }else if(map[ni][nj]=='1'){ // 벽이면

                    if(!now.destroyed){ // 한번도 벽을 부순적이 없다면 부순다~
                        q.add(new Loc(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }
                    // 한번 부순 적이 있다면 또 부수고 갈 수 없기 때문에 pass
                }
            }

        }

        System.out.println(-1);
    }
}
