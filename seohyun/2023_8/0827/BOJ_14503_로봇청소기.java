import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static Node robot;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        robot = new Node(0,0,0);

        st = new StringTokenizer(br.readLine());
        robot.x = Integer.parseInt(st.nextToken());
        robot.y = Integer.parseInt(st.nextToken());
        robot.d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation();
        System.out.println(result);

    }

    // 0 : 청소되지 않은 빈칸
    // -1 : 청소된 빈칸
    // 1 : 벽
    static void simulation(){

        while(true){
            if(map[robot.x][robot.y] == 0){
                map[robot.x][robot.y] = -1;
                result++;
            }
            else{
                int blank = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = robot.x + dx[k];
                    int ny = robot.y + dy[k];
                    if(isCango(nx,ny) == false) continue;
                    if(map[nx][ny] == 0) blank++;
                }

                if(blank != 0){// 청소되지 않은 빈칸이 있는 경우
                    robot.d = (robot.d + 3) % 4;
                    int nx = robot.x + dx[robot.d];
                    int ny = robot.y + dy[robot.d];
                    if(isCango(nx,ny) && map[nx][ny] ==0){
                        robot.x = nx;
                        robot.y = ny;
                    }
                }else{
                    int nx = robot.x + ( dx[robot.d] * -1 );
                    int ny = robot.y + ( dy[robot.d] * -1 );
                    if(map[nx][ny] == 1) return;
                    robot.x = nx;
                    robot.y = ny;
                }
            }
        }
    }

    static boolean isCango(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }


    static class Node{
        int x,y,d;
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
