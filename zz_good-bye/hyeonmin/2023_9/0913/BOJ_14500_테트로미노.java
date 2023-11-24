import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14500
// 2초, 512MB
public class BOJ_14500_테트로미노 {
    
    static final int U = 0;
    static final int D = 1;
    static final int L = 2;
    static final int R = 3;
    static final int LU = 4;
    static final int RU = 5;
    static final int LD = 6;
    static final int RD = 7;
                    //  U   D  L  R     LU  RU  LD  RD
    static int[] dy = { -1, 1, 0, 0, -1, -1,  1, 1 };
    static int[] dx = { 0, 0, -1, 1, -1,  1, -1, 1};
    static int[][] block = {
            { R, R, R },    // ─
            { D, D, D },    // │
            
            { R, D, L },    // □

            { D, D, R },    // └
            { L, L, D },    //  ┌─
            { U, U, L },    // ┐
            { L, L, U },    //  └─
            { U, U, R },    // ┌
            { R, R, D },    //  ─┐
            { D, D, L },    // ┘
            { R, R, U },    //  ─┘

            { D, R, D },    // └┐
            { R, D, R },    // Z
            { D, L, D },    // ┌┘
            { L, D, L },	// Z 반대로
            
            { R, R, LD },    // ┯     
            { D, D, LU },    //  ┤
            { L, L, RU },    //   ┴
            { U, U, RD }    //    ├
    };
    
    
    static int N, M, maxAns;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxAns = Integer.MIN_VALUE;
        map = new int[N][M];
        // 첫째 줄 N과 M --> 4 <= N,M <= 500
        // N개의 줄에 수가 주어짐 => 종이 map
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 맵 전체를 탐색합니다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 총 19가지 형태의 모양을 탐색한다
            	for (int blockNum = 0; blockNum < 19; blockNum++) {
                    makeBlock(blockNum, i, j);
                }
            }
        }
        
        System.out.println(maxAns);
        // 5개의 블럭 중 하나를 골라 
        
        // 4개의 정사각형을 delta로 저장
        // 걸리는 시간?
        // -> 맵 (500 x 500 = 250000)
        // -> 블럭종류 X 방향 (2+1+8+4+4 = 19가지)
        // -> 250000 X 19 = 4750000 (47만)
        // -> 블럭의 개수 4개 -> 4750000 X 4 = 190만
        
    }
    
    static void makeBlock(int blockNum, int i, int j) {
    	int cy = i;
    	int cx = j;
        int sum = map[cy][cx];
    	
        for (int next = 0; next < 3; next++) {
            int nextBlockIdx = block[blockNum][next];
            int ny = cy + dy[nextBlockIdx];
            int nx = cx + dx[nextBlockIdx];
            if( isOutRange(ny, nx) ) return;
            sum += map[ny][nx];
            // 현재값 갱신
            cy = ny;
            cx = nx;
            
        }
        maxAns = Math.max(maxAns, sum);
    }
    
    static boolean isOutRange(int y, int x) {
        return y >= N || y < 0 || x >= M || x < 0;
    }
}
