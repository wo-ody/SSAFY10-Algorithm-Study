package day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {

    static final int TOP = 0;
    static final int BACK = 1;
    static final int RIGHT = 2;
    static final int LEFT = 3;
    static final int FRONT = 4;
    static final int BOTTOM = 5;
    static int N, M, x, y, K;
    static int[][] map;
            //  TOP, BACK, RIGHT, LEFT, FRONT, BOTTOM
    static int[] dice = { 0, 0, 0, 0, 0, 0 };
    
                     // 우   좌      상    하
    static int[] dy = { 0, 0, -1, 1 };
    static int[] dx = { 1, -1, 0, 0 };
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0 ; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 명령어 실행
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            int d = Integer.parseInt(st.nextToken()) - 1; // 보정
            y += dy[d];
            x += dx[d];
            // 1. 주사위 이동
            if( isOutRange(y, x) ) {
            	y -= dy[d];
                x -= dx[d];
            	continue;
            }
            // 2. 주사위 회전
            tumbleDice(d);
            // 3. 값 이동
            if( map[y][x] == 0 ) {
            	map[y][x] = dice[BOTTOM];
            }
            else {
            	dice[BOTTOM] = map[y][x];
            	map[y][x] = 0;
            }
            // 4. 주사위 상단값 출력
            sb.append(dice[TOP]).append("\n");
        }
        
        // 정답 출력
        System.out.println(sb);
    }
    
    static void tumbleDice(int d) {
        int temp = dice[TOP];
        switch (d) {
        case 0 : 
            dice[TOP] = dice[LEFT];
            dice[LEFT] = dice[BOTTOM];
            dice[BOTTOM] = dice[RIGHT];
            dice[RIGHT] = temp;
            break;
        case 1 : 
            dice[TOP] = dice[RIGHT];
            dice[RIGHT] = dice[BOTTOM];
            dice[BOTTOM] = dice[LEFT];
            dice[LEFT] = temp;
            break;
        case 2 : 
            dice[TOP] = dice[FRONT];
            dice[FRONT] = dice[BOTTOM];
            dice[BOTTOM] = dice[BACK];
            dice[BACK] = temp;
            break;
        case 3 : 
            dice[TOP] = dice[BACK];
            dice[BACK] = dice[BOTTOM];
            dice[BOTTOM] = dice[FRONT];
            dice[FRONT] = temp;
            break;
        }
    }
    
    static boolean isOutRange(int y, int x) {
        return y >= N || y < 0 || x >= M || x < 0;
    }

}