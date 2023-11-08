import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    static int res;
    static int N; //맵 사이즈
    static int[][] map;
    static class Data{
        int x, y;

        public Data(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
    static List<Data> list;
    static int tCnt; // 내가 연결시도해야하는 전체 코어갯수
    static int max; //연결된 최대 코어값 관리 변수
    
    static int[] dx = {0,0,-1,1}; //상하좌우
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int t = 1; t <= TC; t++) {
            res = Integer.MAX_VALUE;
            N = sc.nextInt();
            map = new int[N][N];
            list = new ArrayList<>();
            max = Integer.MIN_VALUE; //최소값으로 초기화
            for(int i = 0 ; i < N ; i++) {
                for(int j = 0; j <  N; j++) {
                    map[i][j] = sc.nextInt();
                    if(map[i][j] == 1) { // core 이면
                        if(i == 0 || i == N-1 || j == 0 || j == N-1) {
                            continue;
                        }
                        //연결되지 않은 코어
                        list.add(new Data(j,i));
                    }
                }
            }// 입력완료, 내가 연결 시도해야 하는 코어의 정보와 갯수를 알게됨
            tCnt = list.size();
            dfs(0,0);
            
            System.out.println("#" + t + " " + res );
        }
        
    }
    private static void dfs(int idx, int cnt) {
        //idx 현재 선택할 코어 남은 모든코어가 연결되어도 max를 넘어가지 않는다면
        //t:10  i:7, cnt 3 + 3  <  max: 7
        if(tCnt-idx + cnt < max) {
            return;
        }
        
        
        // 종료될조건이면 더이상 재귀 호출안함(기저조건, base case)
        if(idx == tCnt) {
            //연결된 전선의 갯수를 
            int len = getCount();
            if(max < cnt) {
                max = cnt;
                res = len;
            }else if(max == cnt) {
                res =  Math.min(res, len);
            }
            
            return;
        }
        
        //현재위치 선택함(4방위로 연결을 시도해봐야 함)
        Data cur = list.get(idx);
        for(int d = 0; d < 4; d++) {
            if(isAvaiable(cur.x,cur.y, d)) { //연결가능판단
                //전선그리기
                conneted(cur.x,cur.y, d, 2); // 전선(2)
                dfs(idx+1, cnt + 1);
                //복원
                conneted(cur.x,cur.y, d, 0); // 빈공간(0)
            }
        }
        
        //현재위치 선택안함
        dfs(idx+1, cnt );
        
    }
    private static void conneted(int x, int y, int d, int s) {
        while(true) {
            x = x + dx[d];
            y = y + dy[d];
            if(x < 0 || x >= N || y < 0 || y >= N) {
                break;
            }
            map[y][x] = s;
            
        }
        
    }
    private static boolean isAvaiable(int x, int y, int d) {
        while(true) {
            x = x + dx[d];
            y = y + dy[d];
            if(x== -1 || x == N || y == -1 || y == N) {
                break;
            }
            if(map[y][x] != 0) { //1(코어),2(전선)이 놓여있는경우
                return false;
            }
            
        }
        return true;
    }
    private static int getCount() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 2) { //전선이면
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
