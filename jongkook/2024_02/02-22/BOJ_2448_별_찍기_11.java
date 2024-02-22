package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2448_별_찍기_11 {
    static char[][] stars;
    static boolean[][] visited;
    static int n, row;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        row = (n << 1);
        stars = new char[n][row-1];
        visited = new boolean[n][row];
        makeStar(0, row/2-1);
        for(char[] chr: stars){
            for(char ch: chr){
                if(ch == '*') sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        System.out.println(stars[n-1].length);
    }
    static void makeStar(int y, int x) {
        if(isRange(y, x)) return;
        if(visited[y][x]) return;
        stars[y][x] = '*';
        stars[y+1][x-1] = '*';
        stars[y+1][x+1] = '*';
        visited[y][x] = true;
        visited[y+1][x-1] = true;
        visited[y+1][x+1] = true;
        for(int s = x-2; s <= x+2; s++) {
            stars[y+2][s] = '*';
            visited[y+2][s] = true;
        }
        makeStar(y+3, x-3);
        makeStar(y+3, x+3);
    }
    // 범위를 벗어나면 true
    static boolean isRange(int y, int x){
        return y < 0 || x < 0 || y >= n || x >= row;
    }
}