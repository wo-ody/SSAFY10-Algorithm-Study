package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5653_줄기세포배양 {
    static int n, m, k, ny, nx;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Cell> queue = new ArrayDeque<>(); //살아있는 세포 넣어
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n + k + 2][m + k + 2]; //맵 최대
            visit = new boolean[n + k + 2][m + k + 2];
            queue.clear(); //큐 초기화 

            int temp = 0; //세포 생명
            for (int i = k / 2 + 1; i < n + k / 2 + 1; i++) { //중간 지점부터  
                st = new StringTokenizer(br.readLine());
                for (int j = k / 2 + 1; j < m + k / 2 + 1; j++) {
                    temp = Integer.parseInt(st.nextToken());
                    if (temp != 0) { //세포일때 
                        map[i][j] = temp;
                        visit[i][j] = true;
                        queue.add(new Cell(i, j, temp));
                    }
                }
            }

            int answer = simulation();
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

     static int simulation() {
        int count = k; //k 시간동안 
        Cell cell;
        while (count-- > 0) {
            int len = queue.size();
            for (Cell c : queue) {
                if (c.status == 1) check(c); //활성화 상태라면 생명력 비교
            }

            for (int t = 0; t < len; t++) { //모든 세포들을 돌면서  
                cell = queue.poll(); //살아있는 세포에 대해  
                if (cell.status == 1) { // 활성화 상태라면  
                    for (int i = 0; i < 4; i++) {
                        ny = cell.y + dy[i];
                        nx = cell.x + dx[i];

                        if (visit[ny][nx]) continue;

                        queue.add(new Cell(ny, nx, map[ny][nx])); // 번식된 세포 
                        visit[ny][nx] = true; //증식을 한 세포는 visit                     }
                    }
                }

                cell.next(); // 세포 상태 변화
                
                if (cell.status == 0) continue; // 죽은 세포는 queue에서 제외
                queue.add(cell); //상태 변화된 세포 넣어주기  
            }
        }
        return queue.size(); //살아있는 세포들의 수 
    }

    private static void check(Cell cell) { //생명력이 더 큰 세포 체크하기  
        for (int i = 0; i < 4; i++) {
            ny = cell.y + dy[i];
            nx = cell.x + dx[i];

            if (visit[ny][nx]) continue;

            if (map[ny][nx] < cell.value) map[ny][nx] = cell.value;
        }
    }

    static class Cell {
        int y,x;
        int value, temp;
        int status;

        public Cell(int y, int x, int value) { //세포생성시 
            this.y = y;
            this.x = x;
            this.value = value; //생명력 
            this.temp = value; //세포 상태  
            this.status = 2;//초기에는 비활성화상태 
        }

        public void next() { //세포 상태 바꿔주기  
            switch (status) {
                case 2: // 비활성화 라면 
                    if (--temp == 0) status = 1; //활성화 될때까
                    break;
                case 1: // 활성화 라면 
                    if (++temp == value) status = 0; //죽을 때까지  
                    break;
            }
        }
    }
}
