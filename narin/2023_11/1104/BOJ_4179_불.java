import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, K, result;
    private static List<Ball>[][] map;
    private static List<Ball> fireball;
    private final static int[][] delta = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    private static void move(){

        for(Ball now: fireball){

            int nr = now.r + (now.s%N)*delta[now.d][0];
            int nc = now.c + (now.s%N)*delta[now.d][1];

            nr = (nr+N)%N;
            nc = (nc+N)%N;

            now.r = nr;
            now.c = nc;

            map[now.r][now.c].add(now);
        }

        fireball.clear();
    }

    private static void putIn(){
        for(int i =0; i<N; i++){
            for(int j =0; j<N; j++){
                if(map[i][j].size()==1){
                    fireball.add(map[i][j].get(0));
                } else if(map[i][j].size()>1){
                    makeBall(i, j);
                }
                map[i][j].clear();
            }
        }
    }

    private static void makeBall(int r, int c){

        int total_m= 0, total_s=0, dir=1;
        boolean even = true, odd = true;

        for(Ball ball : map[r][c]){
            total_m+=ball.m;
            total_s+=ball.s;
            if (ball.d % 2 == 0) odd = false;
            else even = false;
        }

        total_m = total_m/5;
        total_s = total_s/map[r][c].size();

        if(odd||even) dir=0;

        if(total_m==0) return;

        for(int i =0; i<4; i++){
            fireball.add(new Ball(r, c, total_m, total_s, dir));
            dir += 2;
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        fireball = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireball.add(new Ball(r, c, m, s, d));
        }

        for(int i =0; i<K; i++){
            move();
            putIn();
        }


        for(Ball ball: fireball){
            result+= ball.m;
        }
        System.out.println(result);

    }

    static class Ball {
        int r, c, m, s, d; // 질량, 속력, 방향

        public Ball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "[(" + r + ", " + c + ") " + m + ", " + s + ", " + d + "]";
        }
    }
}
