import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16236_아기상어 {

    static int n;
    static int[][] board;
    static int[][] dist;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        Queue<Fish> q = new LinkedList<>();

        // 보드 초기화 및 상어 위치 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    q.add(new Fish(i, j, 0)); // 초기 상어 위치에서 bfs 시작을 위해 큐에 넣음
                    board[i][j] = 0;
                }
            }
        }

        int eat = 0; // 먹은 물고기 수
        int time = 0; // 걸린 시간(정답)
        int size = 2; // 현재 상어 크기

        // 시뮬레이션
        while (true) {
            // 현재 시도에서 먹을 수 있는 물고기를 우선순위에 따라 담아 놓는 우선순위 큐
            // 가까운 순 물고기
            // 거리가 같다면 위 쪽 물고기
            // 위쪽에 같은 거리가 여러개라면 가장 왼쪽 물고기
            PriorityQueue<Fish> fish = new PriorityQueue<>((f1, f2) -> {
                return f1.dist == f2.dist ?
                        f1.x == f2.x ? f1.y - f2.y : f1.x - f2.x
                        : f1.dist - f2.dist;
            });

            //현재 시도에서 갈 수 있는 거리를 표시하는 배열
            dist = new int[n][n];

            // bfs - 현재 상어 위치에서 각 위치까지 갈 수 있는 거리 구하기
            while (!q.isEmpty()) {
                Fish current = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if (canGo(nx, ny, size)) { // 상어가 이동할 수 있으면
                        dist[nx][ny] = dist[current.x][current.y] + 1; // 이동 거리 업데이트
                        q.add(new Fish(nx, ny, dist[nx][ny]));
                        if (canEat(nx, ny, size)) // 물고기를 먹을 수 있다면
                            fish.add(new Fish(nx, ny, dist[nx][ny])); // 우선순위 큐에 추가
                    }
                }
            }
            // 먹을 수 있는 물고기가 없다면 답을 출력하고 끝
            if (fish.size() == 0) {
                System.out.println(time);
                return;
            }
            // 먹을 수 있는 물고기가 있다면
            Fish currentFish = fish.poll(); // 먹을 물고기 (= 상어의 다음 위치)
            time += currentFish.dist; // 물고기를 먹으로 가는데 걸린 시간 더해주기
            eat++; // 먹은 물고기 수 업데이트
            board[currentFish.x][currentFish.y] = 0; // 보드에 물고기를 먹었다고 표시
            if (eat == size) { // 먹은 물고기 수가 현재 상어의 크기와 같다면
                size++; // 상어크기 업데이트
                eat = 0; // 먹은 물고기수 초기화
            }
            q.add(new Fish(currentFish.x, currentFish.y, 0)); // 업데이트된 상어의 위치에서 다시 각 위치까지 갈 수 있는 거리를 계산
        }
    }

    // 상어의 이동 여부
    static boolean canGo(int x, int y, int size) {
        if (x < 0 || x >= n || y < 0 || y >= n) return false; // 범위 밖일때
        if (dist[x][y] != 0) return false; // 이미 방문한 적이 있을때
        if (board[x][y] > size) return false; // 상어 크기보다 큰 물고기가 있을 때
        return true;
    }

    // 물고기 먹음 여부
    static boolean canEat(int x, int y, int size) {
        if (board[x][y] == 0 || board[x][y] == 9) return false; // 물고기 아니라면
        if (board[x][y] >= size) return false; // 물고기가 상어크기보다 크거나 같다면
        return true;
    }

    // 물고기 정보
    public static class Fish {
        int x;
        int y;
        int dist;
        public Fish(int x, int y, int dist) {
            super();
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}    
