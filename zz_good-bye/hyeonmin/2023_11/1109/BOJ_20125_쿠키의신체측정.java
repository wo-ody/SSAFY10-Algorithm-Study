package Algorithm_2023.src.month11.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_20125_쿠키의신체측정 {

    static int N;
    static char[][] map;
    static int[] heart, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        ans = new int[5];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 1. 머리 찾아서 심장을 찾는다.(한칸 아래)
        // 2. 심장 왼쪽, 오른쪽, 아래쪽을 찾는다.
        // 3. 아래쪽(허리)을 찾으면서 제일 끝을 저장해둔다.
        // 4. 왼쪽 대각선, 오른쪽 대각선으로 한칸씩 이동후 아래로 찾는다.

        // 1. 머리 찾아서 심장을 찾는다.(한칸 아래)
        heart = new int[2];
        boolean isFind = false;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == '*') {
                    heart[0] = y+1; // 머리 한칸 밑 = 심장
                    heart[1] = x;
                    isFind = true;
                    break;
                }
            }
            if (isFind) break;
        }

        //   상 하 좌 우
        // y -1 1  0 0
        // x  0 0 -1 1
        // 2. 심장 왼쪽, 오른쪽, 아래쪽을 찾는다.
        int y = heart[0];
        int x = heart[1];
        // 왼쪽 팔
        for (int cnt = 1; cnt < N; cnt++) {
            if( isOutRange(x-cnt) || map[y][x-cnt] != '*' ) {
                ans[0] = cnt-1;
                break;
            }
        }

        // 오른쪽 팔
        for (int cnt = 1; cnt < N; cnt++) {
            if( isOutRange(x+cnt) || map[y][x+cnt] != '*' ) {
                ans[1] = cnt-1;
                break;
            }
        }
        // 허리 (다리 계산을 위해 허리 값 저장, y만, x는 그대로)
        // 사실 정확히는 허리 한 칸 밑 y를 저장한다(다음 계산을 편하게 하기위해)
        int[] pelvis = new int[2];
        for (int cnt = 1; cnt < N; cnt++) {
            if( isOutRange(y+cnt) || map[y+cnt][x] != '*' ) {
                y = y + cnt;
                ans[2] = cnt-1;
                break;
            }
        }

        // 왼쪽 다리 ( 이미 y를 다리 옆으로 저장했음 )
        for (int cnt = 1; cnt < N; cnt++) {
            if( isOutRange(y+cnt) || map[y+cnt][x-1] != '*' ) {
                ans[3] = cnt;
                break;
            }
        }

        // 오른쪽 다리
        for (int cnt = 1; cnt < N; cnt++) {
            if( isOutRange(y+cnt) || map[y+cnt][x+1] != '*' ) {
                ans[4] = cnt;
                break;
            }
        }

        // 정답 출력 (좌표 보정 후)
        sb.append(heart[0]+1).append(" ").append(heart[1]+1).append("\n")
                .append(ans[0]).append(" ")
                .append(ans[1]).append(" ")
                .append(ans[2]).append(" ")
                .append(ans[3]).append(" ")
                .append(ans[4]);
        System.out.println(sb);
    }

    static boolean isOutRange(int yx) {
        return yx >= N || yx < 0;
    }
}