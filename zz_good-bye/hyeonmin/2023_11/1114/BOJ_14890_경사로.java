package Algorithm_2023.src.month11.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {

    static int N, L, cnt;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0 ; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
            // 가로 한줄 완성 > 경사로 놓으러 이동
            if( isValidRow(y) ) {
//                System.out.println("y : " + y + "true");
                cnt++;
            } else {
//                System.out.println("y : " + y + "false");
            }
        }

        for (int x = 0; x < N; x++) {
            if( isValidColumn(x) ) {
//                System.out.println("x : " + x + "true");
                cnt++;
            } else {
//                System.out.println("x : " + x + "false");
            }
        }
        // 2 ≤ N ≤ 100
        // 1 ≤ L ≤ N
        // 1 ≤ 각 칸의 높이 ≤ 10
        // 경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
        // 낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
        // 경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속되어 있어야 한다.

        // 첫번째 인덱스에서 시작해서 이동하는데 한칸씩 다 확인한다. L만큼
        // 나보다 L거리를 가기 전에 1 높거나 낮은 친구를 만나면 불가능한 라인이 된다.
        // L까지 갔는데 1이상 넘게 차이나는 블럭이 나타나면 그 줄은 불가능한 줄이다.
        // L까지 갔는데 나랑 똑같다? 그럼 계속 이동하면서 확인한다(1 차이나는 인덱스 만날때 까지)
        // 만났으면 출발지점 바꾼다.
        System.out.println(cnt);

    }

    static boolean isValidRow(int y) {
        boolean[] visit = new boolean[N];

        // 1. 내리막 경사로 놓기
        for (int i = 1; i < N; i++) {
            int cur = map[y][i];
            int prev = map[y][i-1];

            if ( prev == cur ) continue;
            // 내리막길 발견
            else if ( prev - 1 == cur ) {
                // i, start, next, end
                // 가능한 바닥인지 확인
                for (int j = i; j < i+L; j++) {
                    if( i+L-1 >= N || map[y][j] != cur || visit[j]) return false; // 경사로 놓기 실패
                    visit[j] = true; // 경사로 표시
                }
                // 경사로 놓기를 성공했다면? i 값을 땡겨준다.
//                i += L;
            // 오르막길 발견
            } else if ( prev + 1 == cur ) {
                if (i-L < 0) return false;
                else {
                    for (int j = i-1; j >= i-L; j--) {
                        if( i-L < 0 || map[y][j] != prev || visit[j] ) return false;
                        visit[j] = true;
                    }
                }
            } else return false;
        }
        return true;
    }

    static boolean isValidColumn(int x) {
        boolean[] visit = new boolean[N];

        // 1. 내리막 경사로 놓기
        for (int i = 1; i < N; i++) {
            int cur = map[i][x];
            int prev = map[i-1][x];

            if ( prev == cur ) continue;
                // 내리막길 발견
            else if ( prev - 1 == cur ) {
                //
                // i, start, next, end
                // 가능한 바닥인지 확인
                for (int j = i; j < i+L; j++) {
                    if( i+L-1 >= N || map[j][x] != cur || visit[j]) return false; // 경사로 놓기 실패
                    visit[j] = true; // 경사로 표시
                }
                // 경사로 놓기를 성공했다면? i 값을 땡겨준다.
//                i += L;
                // 오르막길 발견
            } else if ( prev + 1 == cur ) {
                if (i-L < 0) return false;
                else {
                    for (int j = i-1; j >= i-L; j--) {
                        if( i-L < 0 || map[j][x] != prev || visit[j] ) return false;
                        visit[j] = true;
                    }

                }
            } else return false;
        }
        return true;
    }

}
