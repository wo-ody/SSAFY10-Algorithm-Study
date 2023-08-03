import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 지구온난화 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static char[][] map;
    static char[][] changedMap;
    static Queue<Point> landList = new LinkedList<>();

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        changedMap = new char[R][C];


        // 지도 입력과 함께 땅좌표 저장
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                changedMap[i][j] = tmp.charAt(j);
                if (map[i][j] == 'X') {
                    landList.add(new Point(i, j));
                }
            }
        }

        // 침수
        operate();

        // 좁아진 맵 출력을 위한 인덱스 찾기
        int minX = R;
        int minY = C;
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(changedMap[i][j] == 'X'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        // 좁아진 맵 출력
        for(int i = minX; i<= maxX; i++){
            for(int j = minY; j<=maxY; j++){
                System.out.print(changedMap[i][j]);
            }
            System.out.println();
        }
    }

    public static void operate() {
        while (!landList.isEmpty()) {
            Point cur = landList.poll(); // 땅의 위치를 하나씩 보면서
            int cnt = 0;
            for (int i = 0; i < 4; i++) { // 사방의 바다 개수를 세고
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(isOcean(nx, ny)){
                    cnt++;
                }
            }
            if(cnt >=3){ // 바다 개수가 3개 이상이면
                changedMap[cur.x][cur.y] = '.'; // 해당 땅을 바다로 바꾼다.
            }
        }
    }

    static boolean isOcean(int x, int y){
        if(x<0 || x >=R || y<0 || y>=C){ // map 바깥이면 바다
            return true;
        }
        if(map[x][y] != '.' ){
            return false;
        }
        return true;
    }
}


