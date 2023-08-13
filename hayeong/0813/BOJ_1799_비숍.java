import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비숍_1799 {
    static int N;
    static int board[][];
    static boolean isVisited[][];
    static boolean isBlack[][]; // 검흰검흰...
    static int result[];

    // 오른 위쪽 대각선
    static int[] dx = {-1, -1};
    static int[] dy = {1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        isVisited = new boolean[N][N];
        isBlack = new boolean[N][N];
        result = new int[2];  // 순서대로 검정, 흰색의 최댓값

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                //검정색 칸 생성처리
                isBlack[i][j] = (i % 2 != 0 && j % 2 != 0) || i % 2 == 0 && j % 2 == 0;
            }
        }

        //검정칸 탐색
        search(-1, true, 0);
        //흰칸 탐색
        search(-1, false, 0);

        System.out.println(result[0] + result[1]);
    }

    private static void search(int index, boolean isSearchBlack, int count) {
        for (int i = index + 1; i < N * N; i++) {
            int x = i / N;
            int y = i % N;

            // 현재 탐색중인 색이 아니거나, 비숍을 놓을 수 없거나, 대각선에 비숍이 존재할때,
            if (isBlack[x][y] != isSearchBlack || board[x][y] == 0 || !isValid(x, y)) {
                continue;
            }

            isVisited[x][y] = true;
            search(i, isSearchBlack, count + 1);
            isVisited[x][y] = false;
        }

        int resultIndex = isSearchBlack ? 0 : 1;
        result[resultIndex] = Math.max(result[resultIndex], count);
    }

    private static boolean isValid(int x, int y) {
        //윗 대각선의 비숍만 체크한다.
        for (int i = 0; i < 2; i++) {
            int xx = x;
            int yy = y;

            while (true) {
                if (xx >= N || yy >= N || xx < 0 || yy < 0) {
                    break;
                }
                if (isVisited[xx][yy]) {
                    return false;
                }

                xx += dx[i];
                yy += dy[i];
            }
        }

        return true;
    }
}
