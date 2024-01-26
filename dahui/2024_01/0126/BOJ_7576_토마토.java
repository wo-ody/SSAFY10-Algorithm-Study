import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
    static int M,N,day, fresh; //최소 날짜, 익지 않은 토마토 개수
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static boolean[][] visit;
    static int[][] tomato; //이전 날
    static int[][] tomato2; //오늘
    static Queue<int[]> q = new ArrayDeque<>(); //새로 익은 토마토 좌표 넣음
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        init();
        if (fresh == 0) System.out.println(0);
        else {
            simul();
            System.out.println(day);
        }
    }

    public static void simul() {
        int cnt = 0;
        while(!q.isEmpty()){
            //하루, q.size는 변하므로
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] n = q.poll();
                int y = n[0];
                int x = n[1];

                for(int d=0; d<4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    //맵 밖이거나 이미 익은 토마토라면 pass
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M ||
                            tomato[ny][nx] != 0 || visit[ny][nx]) continue;

                    tomato2[ny][nx] = 1;
                    fresh--;
                    visit[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
            cnt++;
            //이미 다 익었다면 그만두기
            if (fresh == 0) break;
            //날짜 세기와 tomato 바꿔주기, 방문처리 초기화

            tomato = tomato2.clone();
        }
        //q가 다 비었는데 안 익은 토마토가 있다면 -1
        if(fresh != 0) day = -1;
        else day = cnt;
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visit = new boolean[N][M];
        tomato = new int[N][M];
        tomato2 = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                tomato2[i][j] = tomato[i][j];
                if(tomato[i][j] == 0) fresh++; //안익은 토마토 수
                if (tomato[i][j] == 1) {
                    q.add(new int[]{i,j});
                    visit[i][j] = true;
                }
            }
        }
    }
}
