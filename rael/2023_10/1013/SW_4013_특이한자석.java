import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, K, ans;
    static int[] score = {1, 2, 4, 8}; // 4개 자석별 점수
    static int[][] gear; // 자석
    // 각 자석별 방향 기록
    static int[] dir;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            
            gear = new int[4][8];
            
            // 자석 + 날개 입력
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    gear[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 풀이
            ans = 0;
            // K만큼 회전
            // 입력받으면서 처리
            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                // 움직이는 자석, 방향
                int id = Integer.parseInt(st.nextToken()) - 1; // index 0 based
                int dir = Integer.parseInt(st.nextToken());
                
                // 현재 시점의 각 자석의 상태를 확인 => dir 배열 완성 <= 각 자석이 어느 방향으로 회전할 지..
                check(id, dir);
                // 자석 회전
                rotate();
            }
            
            // 남은 자석의 상태로 채점
            for (int i = 0; i < 4; i++) {
                if( gear[i][0] == 1 ) ans += score[i];
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);

    }
    // 회전할 자석과 그 뱡향으로 오른쪽과 왼쪽 자석의 회전방향을 연쇄적으로 이어가면서 결정
    static void check(int id, int d) {
        dir = new int[4]; // 초기화 <= 0 디폴트
        dir[id] = d;
        
        // 오른쪽
        for (int i = id + 1; i < 4; i++) {
            if( gear[i-1][2] != gear[i][6] ) { // 왼 - 오 인접한 값이 다르면
                dir[i] = dir[i-1]*(-1);
            }
        }
        // 왼쪽
        for (int i = id - 1; i >= 0; i--) {
            if( gear[i][2] != gear[i+1][6] ) { // 왼 - 오 인접한 값이 다르면
                dir[i] = dir[i+1]*(-1);
            }
        }
    }

    static void rotate() {
        for (int i = 0; i < 4; i++) {
            int temp;
            // 각 자석별 회전 방향에 따라 회전
            switch(dir[i]) {
                case 1 : // 시계 방향
                    temp = gear[i][7];
                    for (int j = 7; j > 0; j--) {
                        gear[i][j] = gear[i][j-1];
                    }
                    gear[i][0] = temp;
                    break;
                case -1 : // 반시계 방향
                    temp = gear[i][0];
                    for (int j = 0; j < 7; j++) {
                        gear[i][j] = gear[i][j+1];
                    }
                    gear[i][7] = temp;
                    break;
            }
        }
    }
}
