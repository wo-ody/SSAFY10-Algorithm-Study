import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
    static int T, N, res;
    static int map[][];
    static boolean[] visit;     //방문 체크 (디저트의 가짓수)
    static int sx, sy;      //출발 정점
    //우하, 좌하, 좌상, 우상
    static int dx[] = {1, -1, -1, 1};
    static int dy[] = {1, 1, -1, -1};
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            res = -1;       //못 먹었을 경우 상정

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //방문 체크 배열 초기화 (디저트 개수 1~100) 
            visit = new boolean[101];

            //구현
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sx = j;
                    sy = i;
                    dfs(j,i,1,0);     //x,y,디저트 개수(누적),시작 방향
                }
            }

            sb.append("#"+t+" "+res+"\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int cnt, int dir){
        //방문체크
        visit[map[y][x]] = true;
        //현재 방향에서 다음 방향으로 진행(즉, 현재 오는 방향을 고려해야함!!)
        for(int d=dir; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            //맵 벗어났는지 확인
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            //도착지라면, 최대값 업데이트 후 현재 재귀 종료
            if(nx == sx && ny == sy && cnt>=4) {
                res = Math.max(res, cnt);

                //재귀 다 끝나면 원상복구
                //visit[map[y][x]]= false;
                //return;
                break;
            }
            //이미 방문한 카페인지 확인 
            if(visit[map[ny][nx]]) continue;
            //위의 상황 다 아니면 다음 방향으로 계속 이동
            //다시 바로 돌아오거나, 똑같은 디저트 방문하면 안되므로 방문 체크
            visit[map[ny][nx]] = true;
            //재귀 호출
            dfs(nx, ny, cnt+1, d);
            //다 끝나면 더 큰 네모 만들어야 하니깐 원복
            visit[map[ny][nx]] = false;
        }

        //재귀 다 끝나면 원상복구
        //위에 쓰면 여기 안 써도 되는가??
        visit[map[y][x]]= false;
    }
}
