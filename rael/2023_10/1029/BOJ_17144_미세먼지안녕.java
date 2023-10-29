import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T, ans;
    static int[][] map, tempMap;
    
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };
    
    static int[][] cPos = new int[2][2]; // cPos[0][1] : 위쪽 공기청정기 x
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        tempMap = new int[R][C];
        
        int cIdx = 0; // 공기청정기 index
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int n = Integer.parseInt(st.nextToken());
                
                if( n == -1 ) {
                    cPos[cIdx][0] = i;
                    cPos[cIdx][1] = j;
                    cIdx++;
                }
                
                map[i][j] = n;
            }
        }
        
        // 풀이
        for (int i = 0; i < T; i++) {
            // 확산
            spread();
            // 청정
            clear();
        }
        
        // 미세먼지 잔량
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if( map[i][j] <= 0 ) continue;
                ans += map[i][j];
            }
        }
        
        System.out.println(ans);
    }

    static void spread() {
        // tempMap 초기화
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tempMap[i][j] = 0;
            }
        }
        // tempMap 에 풀이를 적용해 간다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tempMap[i][j] += map[i][j]; // 이전 좌표에서 현 좌표에 의미있는 값이 생겼을 수도 있기 때문 (누적)
                
                // 5 로 나눈나머지가 5 이상
                if( map[i][j] < 5 ) continue;
                
                int spreadCnt = map[i][j] / 5;
                
                // 4곳 확산
                for (int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    
                    if( ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1 ) continue;
                    tempMap[i][j] -= spreadCnt;
                    tempMap[ny][nx] += spreadCnt;
                }
            }
        }
        // tempMap => map
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = tempMap[i][j];
            }
        }
    }
    
    static void clear() {
        // tempMap 초기화
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tempMap[i][j] = 0;
            }
        }
        
        // 2개의 공기청정기
        for (int i = 0; i < 2; i++) {
            int ny = cPos[i][0];
            int nx = cPos[i][1] + 1; // 공기청정기 x 다음 위치
            
            // ---->
            while(nx < C-1 ) {
                tempMap[ny][nx+1] = map[ny][nx];
                nx++;
            }
            
            // 위, 아래
            if( i == 0 ) { // 위쪽 청정기
                while( ny > 0 ) {
                    tempMap[ny-1][nx] = map[ny][nx];
                    ny--;
                }
            }else { // 아래쪽 청정기
                while( ny < R-1 ) {
                    tempMap[ny+1][nx] = map[ny][nx];
                    ny++;
                }
            }
            
            // <-----
            while(nx > 0 ) {
                tempMap[ny][nx-1] = map[ny][nx];
                nx--;
            }
            
            // 위, 아래
            if( i == 0 ) { // 위쪽 청정기
                while( ny < cPos[i][0] - 1 ) { // 내려올 때 위쪽 공기청정기의 y 좌표 하나 이전
                    tempMap[ny+1][nx] = map[ny][nx];
                    ny++;
                }
            }else { // 아래쪽 청정기
                while( ny > cPos[i][0] + 1 ) {
                    tempMap[ny-1][nx] = map[ny][nx];
                    ny--;
                }
            }
        }
        
        // tempMap 변경 분 map 반영
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if( i == 0 || i == R - 1 || j == 0 || j == C - 1 || i == cPos[0][0] || i == cPos[1][0])
                    map[i][j] = tempMap[i][j];
            }
        }
    }
}
