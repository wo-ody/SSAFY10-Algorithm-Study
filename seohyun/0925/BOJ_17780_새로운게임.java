import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[][] map;
    static Node[] horse;
    static ArrayList<Integer>[][] hmap;

    static int[] dx = {0,0,0,-1,1};
    static int[] dy = {0,1,-1,0,0};

    static int result;
    static boolean isEnd = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        horse = new Node[K];
        hmap = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                hmap[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            horse[i] = new Node(x-1,y-1,d);
            hmap[x-1][y-1].add(i);
        }

        simulation();
        System.out.println(result);
    }

    static void whiteANDred(int hnum , int nx, int ny , int flag){
        Node cur = horse[hnum];
        //if(hmap[cur.x][cur.y].get(0) != hnum) return;

        //ArrayList<Integer> stay = new ArrayList<>();
        ArrayList<Integer> move = new ArrayList<>();
        boolean isFlag = false;
        for (int horse : hmap[cur.x][cur.y]) {
            move.add(horse);
        }

        if(flag == 1) Collections.reverse(move);

        // hmap 현재 자리 삭제
        hmap[cur.x][cur.y] = new ArrayList<>();

        // hmap 다음 자리 옮기고 , horse 갱신하고
        for (int horse_num : move) {
            hmap[nx][ny].add(horse_num);
            horse[horse_num].x = nx;
            horse[horse_num].y = ny;
        }

        // 옮긴 후에 말이 4개 이상 되는지 확인
        if(hmap[nx][ny].size() >= 4) isEnd = true;
    }

    static int changeDir(int d){
        if(d == 1) return 2;
        else if(d == 2) return 1;
        else if(d == 3) return 4;
        else return 3;
    }

    static void simulation(){
        int turn = 0;

        while(true){
            turn++;

            if(turn > 1000) {
                result = -1;
                break;
            }

            for (int i = 0; i < K; i++) {
                Node cur = horse[i];

                if(hmap[cur.x][cur.y].get(0) != i) continue;

                int nx = cur.x + dx[cur.d];
                int ny = cur.y + dy[cur.d];

                if(isCango(nx,ny) == false || map[nx][ny] == 2){
                    int nd = changeDir(cur.d);
                    horse[i].d = nd;
                    nx = cur.x + dx[nd];
                    ny = cur.y + dy[nd];
                    if(!isCango(nx,ny)) continue;

                    if(map[nx][ny] == 0){ // 흰색
                        whiteANDred(i,nx,ny,0);
                    }
                    else if(map[nx][ny] == 1){ // 빨간색
                        whiteANDred(i,nx,ny,1);
                    }
                }
                else if(map[nx][ny] == 0){ // 흰색
                    whiteANDred(i,nx,ny,0);
                }
                else if(map[nx][ny] == 1){ // 빨간색
                    whiteANDred(i,nx,ny,1);
                }

                if(isEnd){
                    result = turn;
                    return;
                }
            }


        }
    }

    static boolean isCango(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }

    static class Node{
        int x,y,d;
        Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
