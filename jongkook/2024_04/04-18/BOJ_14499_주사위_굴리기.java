package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499_주사위_굴리기 {
    static int N, M, X, Y, K;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
    static int[] currentPosition = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            /*
            * k = 1 right
            * k = 2 left
            * k = 3 up
            * k = 4 down */

            int k = Integer.parseInt(st.nextToken()) - 1;
            move(k);
        }
    }
    static void move(int dir) {
        int x = X + dx[dir];
        int y = Y + dy[dir];
        if(isRange(y, x)) return;

        int temp = currentPosition[5];
        switch(dir){
            case 0:
                currentPosition[5] = currentPosition[2];
                currentPosition[2] = currentPosition[0];
                currentPosition[0] = currentPosition[3];
                currentPosition[3] = temp;
                break;

            case 1:
                currentPosition[5] = currentPosition[3];
                currentPosition[3] = currentPosition[0];
                currentPosition[0] = currentPosition[2];
                currentPosition[2] = temp;
                break;

            case 2:
                currentPosition[5] = currentPosition[1];
                currentPosition[1] = currentPosition[0];
                currentPosition[0] = currentPosition[4];
                currentPosition[4] = temp;
                break;

            default:
                currentPosition[5] = currentPosition[4];
                currentPosition[4] = currentPosition[0];
                currentPosition[0] = currentPosition[1];
                currentPosition[1] = temp;
        }
        X = x;
        Y = y;
        System.out.println(currentPosition[0]);

        if(map[y][x] == 0) map[y][x] = currentPosition[5];
        else {
            currentPosition[5] = map[y][x];
            map[y][x] = 0;
        }


    }
    // 범위를 벗어나면 true
    static boolean isRange(int y, int x){
        return (x < 0 || y < 0 || x >= M || y >= N);
    }
    static class Dice{
        int top, up, right, left, down, bottom;

        public Dice(int top, int up, int right, int left, int down, int bottom) {
            this.top = top;
            this.up = up;
            this.right = right;
            this.left = left;
            this.down = down;
            this.bottom = bottom;
        }

        @Override
        public String toString() {
            return "Dice{" +
                    "top=" + top +
                    ", up=" + up +
                    ", right=" + right +
                    ", left=" + left +
                    ", down=" + down +
                    ", bottom=" + bottom +
                    '}';
        }
    }
}
