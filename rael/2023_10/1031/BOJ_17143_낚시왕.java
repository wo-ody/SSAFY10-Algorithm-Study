import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//시뮬레이션
public class Main {
	static int R, C, M, sum;
    static Shark[][] map;
    static List<Shark> list = new ArrayList<>();
    
    //  d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0 ,0, 1,-1 };
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new Shark[R + 1][C + 1]; // 0 dummy
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            Shark shark = new Shark(r, c, s, d - 1, z); // d <= delta 위치 보정
            list.add(shark);
            map[r][c] = shark;
        }
        
        // 풀이
        for (int i = 1; i <= C; i++) { // col 을 이동하면서
            // 상어를 잡는다.
            catchShark(i);
            // 상어 이동
            moveShark();
            // 상어 정리
            killShark();
        }
        
        System.out.println(sum);
    }

    // map 에서 상어를 잡는다.
    static void catchShark(int col) { // col 자리에서 아래로 이동하면서 
        for (int i = 1; i <= R; i++) { // 밑으로 이동하면서
            if( map[i][col] != null ) {
                sum += map[i][col].z;
                list.remove(map[i][col]);
                break;
            }
        }
    }
    
    // list 에서 처리
    // map 변화 적용X
    static void moveShark() {
        for (Shark shark : list) {
            int r = shark.r;
            int c = shark.c;
            int s = shark.s;
            int d = shark.d;
            
            switch(d) {
                // 상,하
                case 0:
                case 1:
                    s = s % ((R-1)*2); // 제자리로 오는 계산을 수학적으로 선처리 후 남는 부분만 이동
                    for (int i = 0; i < s; i++) {
                        // 양끝이면 방향 전환
                        if( r == 1 ) d = 1; // 상 -> 하
                        else if( r == R ) d = 0; // 하 -> 상
                        r += dy[d];
                    }
                    shark.r = r;
                    shark.d = d;
                    break;
                // 우,좌
                case 2:
                case 3:
                    s = s % ((C-1)*2); // 제자리로 오는 계산을 수학적으로 선처리 후 남는 부분만 이동
                    for (int i = 0; i < s; i++) {
                        // 양끝이면 방향 전환
                        if( c == 1 ) d = 2; // 좌 -> 우
                        else if( c == C ) d = 3; // 우 -> 좌
                        c += dx[d];
                    }
                    shark.c = c;
                    shark.d = d;
                    break;
            }
        }
    }
    // 기존 맵 초기화
    // list -> map 기록하면서 겹치면 잡아먹는 처리
    static void killShark() {
        // map 초기화
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                map[i][j] = null;
            }
        }
        
        // list 를 이용해서 map 정리
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) { // 삭제 대응 뒤부터
            Shark s = list.get(i);
            if( map[s.r][s.c] == null ) { // 비워져 있으면 연결만
                map[s.r][s.c] = s;
            }else { // 겹치는 상어 존재
                if( s.z > map[s.r][s.c].z ) { // list 에서 꺼낸 상어가 더 크다.
                    list.remove(map[s.r][s.c]);
                    map[s.r][s.c] = s;
                }else { // list 에서 꺼낸 상어가 더 작거나 같다. // 있는 상어를 남긴다.
                    list.remove(i); // index
                }
            
            }
        }
    }
    
    //  (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다
    static class Shark{
        int r, c, s, d, z;
        Shark( int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
