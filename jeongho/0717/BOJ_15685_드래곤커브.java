import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15685_드래곤커브 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] dy = { 0, -1, 0, 1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src.input.txt"));
        for (int i = 0; i < 4; i++) {
            int N = Integer.parseInt(br.readLine());
            boolean[][] map = new boolean[101][101];
            for (int n = 0; n < N; n++) {
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                int d = Integer.parseInt(s[2]);
                int g = Integer.parseInt(s[3]);

                map[y][x] = true;
                
            }

        }

    }

    static void dc(boolean[][] map, int x, int y, int d, int g) {
        x += dx[d];
        y += dy[d];
        map[y][x] = true;
        if (g > 1) {
            for (int i = 0; i < g - 2; i++) {
                d = nextD(d, '+');
                x += dx[d];
                y += dy[d];
                map[y][x] = true;

            }
            for (int i = 0; i < g - 1; i++) {
                d = nextD(d, '-');
                x += dx[d];
                y += dy[d];
                map[y][x] = true;

            }
        }

    }

    static int nextD(int d, char c) {
        switch (c) {
        case '-':
            d--;
            if (d < 0) {
                d = 3;
            }
        default:
            d++;
            if (d > 3) {
                d = 0;
            }

        }
        return d;
    }
}