import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int res;
    static int N, M, Y,X, L ;//세로, 가로, 터널y,x, 시간
    static int[][] map;
    static int[] dx = {0,0,-1,1}; //상하좌우
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int t = 1; t <= TC; t++) {
            res = 0; //갯수세기의 초기값 활용
            N = sc.nextInt();
            M = sc.nextInt();
            Y = sc.nextInt();
            X = sc.nextInt();
            L = sc.nextInt();
            map = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }//입력 완료
            bfs();
            System.out.println("#" + t + " " + res);
        }

    }
    static class Data{
        int x, y;
        int cnt;
        public Data(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
    }
    static void bfs() {
        Queue<Data> q = new LinkedList<>();
        boolean[][] v = new boolean[N][M];
        
        q.offer(new Data(X,Y,0));
        v[Y][X] = true;
        
        Data cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            if(cur.cnt >= L) { // L == cnt
                break;
            }
            res++; //이동가능한 위치니까 숫자 누적해주기
            //4방위로 연결되 터널이 있으면 다음큐에 삽입하기
            int nx, ny;
            for(int d = 0; d < 4; d++ ) {
                nx = cur.x + dx[d];
                ny = cur.y + dy[d];
                //범위체크
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }
                //이미방문한곳 체크
                if(v[ny][nx]) {
                    continue;
                }
                //터널없는곳 체크
                if(map[ny][nx] == 0) {
                    continue;
                }
                //기존터널과, 다음터널사이의 연결여부 체크하기
                if(!isMove(map[cur.y][cur.x], map[ny][nx], d)) {
                    continue;
                }
                //큐에 삽입하기                
                q.offer(new Data(nx,ny, cur.cnt + 1 ));
                v[ny][nx] = true;
            }
            
        }
        
        
    }
    private static boolean isMove(int cb, int nb, int d) {
        if(cb == 1) {// 상 하 좌 우 연결확인
            if(d == 0) { //상
                if(nb == 1 || nb == 2 || nb == 5 || nb == 6) {
                    return true;
                }
            }
            if(d == 1) { //하
                if(nb == 1 || nb == 2 || nb == 4 || nb == 7) {
                    return true;
                }
            }
            if(d == 2) { //좌
                if(nb == 1 || nb == 3 || nb == 4 || nb == 5) {
                    return true;
                }
            }
            if(d == 3) { //우
                if(nb == 1 || nb == 3 || nb == 6 || nb == 7) {
                    return true;
                }
            }
        }
        if(cb == 2) {// 상 하  연결확인
            if(d == 0) { //상
                if(nb == 1 || nb == 2 || nb == 5 || nb == 6) {
                    return true;
                }
            }
            if(d == 1) { //하
                if(nb == 1 || nb == 2 || nb == 4 || nb == 7) {
                    return true;
                }
            }
        }
        if(cb == 3) {//좌 우 연결확인
            if(d == 2) { //좌
                if(nb == 1 || nb == 3 || nb == 4 || nb == 5) {
                    return true;
                }
            }
            if(d == 3) { //우
                if(nb == 1 || nb == 3 || nb == 6 || nb == 7) {
                    return true;
                }
            }
        }
        if(cb == 4) {// 상  우 연결확인
            if(d == 0) { //상
                if(nb == 1 || nb == 2 || nb == 5 || nb == 6) {
                    return true;
                }
            }
            if(d == 3) { //우
                if(nb == 1 || nb == 3 || nb == 6 || nb == 7) {
                    return true;
                }
            }
        }
        if(cb == 5) {// 하 우 연결확인
            if(d == 1) { //하
                if(nb == 1 || nb == 2 || nb == 4 || nb == 7) {
                    return true;
                }
            }
            if(d == 3) { //우
                if(nb == 1 || nb == 3 || nb == 6 || nb == 7) {
                    return true;
                }
            }
        }
        if(cb == 6) {// 하 좌 연결확인
            if(d == 1) { //하
                if(nb == 1 || nb == 2 || nb == 4 || nb == 7) {
                    return true;
                }
            }
            if(d == 2) { //좌
                if(nb == 1 || nb == 3 || nb == 4 || nb == 5) {
                    return true;
                }
            }
        }
        if(cb == 7) {// 상 좌  연결확인
            if(d == 0) { //상
                if(nb == 1 || nb == 2 || nb == 5 || nb == 6) {
                    return true;
                }
            }
            if(d == 2) { //좌
                if(nb == 1 || nb == 3 || nb == 4 || nb == 5) {
                    return true;
                }
            }
        }
        return false;
    }
}


