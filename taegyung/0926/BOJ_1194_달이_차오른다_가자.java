package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이_차오른다_가자 {

        // 열쇠를 써야 이동할 수 있다.
        // 열쇠는 여러번 사용할 수 있다.
        static int N, M;
        static int[] dx = { -1, 0, 0, 1 };
        static int[] dy = { 0, -1, 1, 0 };
        static char[][] miro;
        // visited를 3차원 배열로 만들자

        static boolean[][] visited;
        static int [][]visited_cnt;
        static int [][]keys;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 미로를 탈출할 수 없으면 -1을 출력해야 한다.

            miro = new char[N][M];

            for (int i = 0; i < N; i++) {
                miro[i] = br.readLine().toCharArray();
            }

            visited = new boolean[N][M];
            visited_cnt = new int[N][M];
            for(int i = 0 ; i < N ; i ++){
                for(int j =  0 ; j < M ; j++){
                    visited_cnt[i][j] = Integer.MAX_VALUE;
                }
            }
            keys = new int [N][M]; // 위치에 저장하는 비트마스킹
            // 들르는지, 열쇠를 갖고 있는지

            // 0이 민식이가 서 있는 곳.
            // 1이 출구
            // . 빈 칸
            // # 벽
            // 소문자 : 열쇠
            // 대문자 : 문

            int start_x = -1;
            int start_y = -1;

            int end_x = -1;
            int end_y = -1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (miro[i][j] == '1') {
                        end_x = i;
                        end_y = j;
                    }
                    if (miro[i][j] == '0') {
                        start_x = i;
                        start_y = j;
                    }

                }
            }

            // 입력은 다 받았는데 그럼 미로 돌아다니자
//            visited[start_x][start_y] = new boolean[] { true, false, false, false, false, false, false };
            visited[start_x][start_y] = true;
            visited_cnt[start_x][start_y] = 0;
            int result = dfs(start_x, start_y);

            if (result != Integer.MAX_VALUE)
                System.out.println(result);
            else {
                System.out.println(-1);
            }

        }

        static int dfs(int now_x, int now_y) {

            if (miro[now_x][now_y] == '1') {
                return 0; // -> 여기가 마지막임
            }
            // 비트마스킹으로 확인하자

            if (miro[now_x][now_y] -'a' >= 0 &&miro[now_x][now_y] -'a' <6){
                keys[now_x][now_y] |= (1<<miro[now_x][now_y] -'a');
                // 역순으로 들어가게 될 것.

            }
            // 네 방향으로 진행했을 때의 최소들을 리턴해야함.

            int min = Integer.MAX_VALUE;
            for (int d = 0; d < 4; d++) {
                int nx = now_x + dx[d];
                int ny = now_y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (miro[nx][ny] != '#') {

                    if (miro[nx][ny] - 'A' >= 0 && miro[nx][ny] - 'A' < 6){
                        if ((keys[now_x][now_y] & (1<<miro[nx][ny] - 'A') )== 0){
                            continue;
                        }
                    }
                    // 이걸로 열쇠와 벽 사이의 상관관계 해결
                    int n_key_cnt = Integer.bitCount(keys[nx][ny]);

                    int c_key_cnt = Integer.bitCount(keys[now_x][now_y]);

                    if (visited[nx][ny] == false || c_key_cnt > n_key_cnt) {
                        // 아직 들르지 않은 곳이거나 키 정보가 더 적은 곳일 때
                        // 원복을 위해 저장
                        boolean before_visited = visited[nx][ny];
                        visited[nx][ny] = true;
                        int tmp = keys[nx][ny]; // 저장
                        keys[nx][ny] = keys[now_x][now_y];
                        // 재귀로 들어가고
                        int result = dfs(nx, ny);
                        if (result != Integer.MAX_VALUE)
                            min = Math.min(1 + result, min);

                        visited[nx][ny] = before_visited;
                        keys[nx][ny] = tmp;
                    }

                }
            }

            return min;

        }

        static void bfs(int start_x,int start_y){
            Queue<int[]> queue = new ArrayDeque<>();

            queue.offer(new int []{start_x,start_y});

            while(!queue.isEmpty()){
                int [] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];

                for(int d = 0 ; d < 4 ; d ++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >=M || miro[nx][ny] == '#')continue;
                    int n_key_cnt = Integer.bitCount(keys[nx][ny]);

                    int c_key_cnt = Integer.bitCount(keys[x][y]);

                    if (visited_cnt[nx][ny] > visited_cnt[x][y] + 1 || n_key_cnt > c_key_cnt){

                        if (miro[nx][ny] - 'A' >= 0 && miro[nx][ny] - 'A' < 6){
                            if ((keys[now_x][now_y] & (1<<miro[nx][ny] - 'A') )== 0){
                                continue;
                            }
                        }

                        visited_cnt[nx][ny] = visited_cnt[x][y] + 1;
                        // 다시 큐에 넣음
                        queue.offer(new int []{nx,ny});

                        // 이제 할거 해야지





                    }
                }
            }
            if (miro[now_x][now_y] == '1') {
                return 0; // -> 여기가 마지막임
            }
            // 비트마스킹으로 확인하자

            if (miro[now_x][now_y] -'a' >= 0 &&miro[now_x][now_y] -'a' <6){
                keys[now_x][now_y] |= (1<<miro[now_x][now_y] -'a');
                // 역순으로 들어가게 될 것.

            }
            // 네 방향으로 진행했을 때의 최소들을 리턴해야함.

            int min = Integer.MAX_VALUE;
            for (int d = 0; d < 4; d++) {
                int nx = now_x + dx[d];
                int ny = now_y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (miro[nx][ny] != '#') {

                    if (miro[nx][ny] - 'A' >= 0 && miro[nx][ny] - 'A' < 6){
                        if ((keys[now_x][now_y] & (1<<miro[nx][ny] - 'A') )== 0){
                            continue;
                        }
                    }
                    // 이걸로 열쇠와 벽 사이의 상관관계 해결
                    int n_key_cnt = Integer.bitCount(keys[nx][ny]);

                    int c_key_cnt = Integer.bitCount(keys[now_x][now_y]);

                    if (visited[nx][ny] == false || c_key_cnt > n_key_cnt) {
                        // 아직 들르지 않은 곳이거나 키 정보가 더 적은 곳일 때
                        // 원복을 위해 저장
                        boolean before_visited = visited[nx][ny];
                        visited[nx][ny] = true;
                        int tmp = keys[nx][ny]; // 저장
                        keys[nx][ny] = keys[now_x][now_y];
                        // 재귀로 들어가고
                        int result = dfs(nx, ny);
                        if (result != Integer.MAX_VALUE)
                            min = Math.min(1 + result, min);

                        visited[nx][ny] = before_visited;
                        keys[nx][ny] = tmp;
                    }

                }
            }

            return min;

        }


    }