import java.io.*;
import java.util.*;

public class Main {

    private static int result;
    private static char[][] field = new char[12][6];
    private static int[][] delta = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};  // 하우좌상
    private static List<Point> puyo;
    private static boolean[][] isVisited;

    private static void colorCount(int x, int y, char color) {

        for (int[] d : delta) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
            if (isVisited[nx][ny] || field[nx][ny] != color) continue;

            isVisited[nx][ny] = true;
            colorCount(nx, ny, color);
            puyo.add(new Point(nx, ny));
        }

    }


    private static void remove() {

        for (Point p : puyo) {
            field[p.x][p.y] = '.';
        }

        puyo.clear();
    }

    private static void clean() {

        for(int i =0; i<6; i++){
            for(int j = 11; j>0; j--){
                if(field[j][i] == '.'){
                    for(int k =j-1; k>=0; k--){
                        if(field[k][i] !='.'){
                            field[j][i] = field[k][i];
                            field[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = 0;
        puyo = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = str.charAt(j);
            }
        }

        while (true) {
            boolean isFinished = true;
            isVisited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.') {
                        isVisited[i][j] = true;
                        puyo.add(new Point(i, j));
                        colorCount(i, j, field[i][j]);
                        if (puyo.size() < 4) {
                            puyo.clear();
                        } else {
                            isFinished = false;
                            remove();
                        }
                    }
                }
            }

            if (isFinished) break;
            clean();
            result++;
        }
        System.out.println(result);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }
}
