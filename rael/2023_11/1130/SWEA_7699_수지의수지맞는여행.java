import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//요금은 최소, 방문은 최대
//DFS로 풀이할 수 있을 듯!
public class SWEA_7699_수지의수지맞는여행 {
    static int T, R, C, res;            //결과
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char map[][];                //지도 저장
    static boolean[] visit;             //방문 체크
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            //초기화
            map = new char[R][];        //toCharArray는 뒤에 정의 안 해줘도 됨!
            visit = new boolean[26];    //알파벳은 26개
            res = 0;

            //입력
            for(int i=0; i<R; i++){
                String s = br.readLine();
                map[i] = s.toCharArray();
            }

            //풀이
            visit[map[0][0]-'A'] = true;
            dfs(1, 0, 0);       //cnt, x, y

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }

    static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void dfs(int cnt, int x, int y){
        // 모든 여행지 방문
        if(res == 26) return;
        //최대 업데이트
        if(cnt > res){
            res = cnt;
        }

        //풀이
        //사방향으로 여행
        for(int d=0; d<4; d++){
            int ny = y+dy[d];
            int nx = x+dx[d];

            //범위 체크 & 방문 체크
            if(ny<0||nx<0||ny>=R||nx>=C || visit[map[ny][nx]-'A']) continue;
            //방문체크
            visit[map[ny][nx]-'A'] = true;
            dfs(cnt+1, nx, ny);
            //원복
            visit[map[ny][nx]-'A'] = false;
        }

    }
}
