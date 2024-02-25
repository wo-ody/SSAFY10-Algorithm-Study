package algorithm2024.feb.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        boolean[][] map = new boolean[101][101];
        int ans = 0;
        for (int t = 0; t< 4; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y]=true;
                }
            }
        }
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if(map[i][j])ans++;
            }
        }
        System.out.println(ans);
    }
}
