import java.util.*;
import java.io.*;

//한수 왼쪽 아래(0,R), 집은 오른쪽 위(C,0)
//T로는 갈 수 X
//거리가 K가 되는 가짓수를 구하라

public class BOJ_1189_컴백홈 {
    static char[][] map;
    static int R,C,K,cnt;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //map 초기화
        map = new char[R][C];
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }

        //dfs
        cnt = 0;
        map[R-1][0] = '1';  //시작점
        dfs(0,R-1,1);   //왼쪽 아래에서 시작

        System.out.println(cnt);
    }

    static void dfs(int x, int y, int dist){
        //기저조건(집 도착)
        if(y==0 && x==C-1 && dist==K) {
            cnt++;
            return;
        }

        for(int d=0; d<4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            //범위 체크
            if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
            //왔던 길인지 체크
            if(map[ny][nx]!='.') continue;

            //왔던 길 안 돌아가도록
            map[ny][nx] = '1';

            //다음 스텝
            dfs(nx, ny, dist+1);

            //원복
            map[ny][nx] = '.';
        }
    }
}
