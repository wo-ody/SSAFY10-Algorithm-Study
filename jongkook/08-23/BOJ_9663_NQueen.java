package algorithmstudy.backtracking;

import java.io.*;

public class BOJ_9663_NQueen {
    static boolean[][] visited;
    static int[][] map;
    static int N, count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        queen(0, 0);
        System.out.println(count);
    }

    static void queen(int x, int y){
        if(x == N || y == N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(noQueen(x,i)){
                visited[x][i] = true;
                queen(x+1, y);
                visited[x][i] = false;
            }
        }
    }

    static boolean noQueen(int x, int y){
        // 같은 열에 퀸이 있는지 검사
        for(int i = 0; i < x; i++){
            if(visited[i][y]) return false; // 있다면 false

            // 왼쪽 대각선 아래에 퀸이 있는지 검사
            if (y - (x - i) >= 0 && visited[i][y - (x - i)]) {
                return false;
            }
            // 오른쪽 대각선 아래에 퀸이 있는지 검사
            if (y + (x - i) < N && visited[i][y + (x - i)]) {
                return false;
            }
        }


        return true;

    }

}
