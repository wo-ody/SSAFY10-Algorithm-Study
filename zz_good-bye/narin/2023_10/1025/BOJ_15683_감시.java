import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, area, size;
    private static int[][] room, arr;
    private static int[] index;
    private static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static List<Point> cctv;

    static class Point {
        int num, x, y;

        public Point(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }

    }

    private static void comb(int count) {

        if (count == size) {

            arr = new int[N][M];
            Copy();

            direction(index);

            area = Math.min(area, Count());

            return;
        }

        for (int i = 0; i < 4; i++) {
            index[count] = i;
            comb(count + 1);
        }
    }

    private static void Copy() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = room[i][j];
            }
        }
    }

    private static void direction(int[] index) {

        for (int i = 0; i < size; i++) {
            Point no = cctv.get(i);
            int idx = index[i];

            switch (no.num) {
                case 1:
                    watch(no, idx);
                    break;
                case 2:
                    if (idx == 0 || idx == 2) {
                        watch(no, 0);
                        watch(no, 2);
                    } else {
                        watch(no, 1);
                        watch(no, 3);
                    }
                    break;
                case 3:
                    if (idx == 0) {
                        watch(no, 0);
                        watch(no, 1);
                    } else if (idx == 1) {
                        watch(no, 1);
                        watch(no, 2);
                    } else if (idx == 2) {
                        watch(no, 2);
                        watch(no, 3);
                    } else {
                        watch(no, 3);
                        watch(no, 0);
                    }
                    break;
                case 4:
                    if (idx == 0) {
                        watch(no, 0);
                        watch(no, 1);
                        watch(no, 2);
                    } else if (idx == 1) {
                        watch(no, 1);
                        watch(no, 2);
                        watch(no, 3);
                    } else if (idx == 2) {
                        watch(no, 0);
                        watch(no, 2);
                        watch(no, 3);
                    } else {
                        watch(no, 0);
                        watch(no, 1);
                        watch(no, 3);
                    }
                    break;
                case 5:
                    watch(no, 0);
                    watch(no, 1);
                    watch(no, 2);
                    watch(no, 3);
                    break;
            }
        }

    }

    private static void watch(Point pos, int d) {

        int x = pos.x;
        int y = pos.y;

        while (true) {
            int nx = x + delta[d][0];
            int ny = y + delta[d][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if (arr[nx][ny] < 0) break;

            arr[nx][ny] = 9;
            x = nx;
            y = ny;
        }
    }

    private static int Count() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        cctv = new ArrayList<>();
        area = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 6) {
                    room[i][j] = -1;
                } else if (room[i][j] > 0) {
                    cctv.add(new Point(room[i][j], i, j));
                }
            }
        }

        size = cctv.size();
        index = new int[size];

        comb(0);

        System.out.println(area);
    }
}
