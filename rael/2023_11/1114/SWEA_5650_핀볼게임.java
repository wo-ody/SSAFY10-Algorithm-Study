import java.util.Scanner;

public class Solution {

    static int res;
    static int N; //맵사이즈
    static int[][] map;
    static int[] dx = {0,-1,0,1}; //상,좌,하,우
    static int[] dy = {-1,0,1,0}; //상,좌,하,우
    static int[][] walls ={ //1~5장애물
        {},
        {3,1,2,0},
        {0,1,3,2},
        {0,2,1,3},
        {1,0,2,3},
        {0,1,2,3}
    };
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int t = 1; t <= TC ; t++) {
            res = 0; // 최대값을구하는
            N = sc.nextInt();
            map = new int[N][N];
            for(int i = 0 ; i < N; i++) {
                for(int j = 0; j < N ; j++) {
                    map[i][j] = sc.nextInt();
                }
            }//입력
            //시뮬레이션
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 0) { //시뮬레이션 구현
                        map[i][j] = -1; //블랙홀 설정
                        for(int d = 0; d < 4;d++) {
                            res = Math.max(res, sol(j, i, d));
                        }
                        map[i][j] = 0; //블랙홀 해제
                    }
                }
            }
            System.out.println("#" + t + " " + res);
        }
    }
    private static int sol(int x, int y, int d) {
        int cnt = 0;
        int nx, ny;
        while(true) { //게임이 종료 될때까지 무한 반복
            nx = x;
            ny = y;
            while(true) {
                nx = nx + dx[d];
                ny = ny + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) { //맵을 벗어나면 반복문 벗어나기
                    break;
                }
                if(map[ny][nx] != 0) { //장애물,웜홀,블랙홀
                    break;
                }
            }
            
            //맵벗어난경우, 장애물,웜홀,블랙홀
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) { //맵벗어난경우
                cnt++;
                d = (d + 2)%4;
                x = nx;
                y = ny;
            }else if(map[ny][nx] >=1 && map[ny][nx] <=5){ //장애물
                cnt++;
                int type = map[ny][nx]; //장애물
                d = walls[type][(d+2)%4];
                x = nx;
                y = ny;
            }else if(map[ny][nx] >=6 && map[ny][nx] <=10) { //웜홀
                loop:for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        if(map[ny][nx] == map[i][j] && !(i==ny && j == nx)) {
                            x = j;
                            y = i;
                            break loop;
                        }
                    }
                }
            }else {
                break;
            }
        }
        return cnt;
    }

}
