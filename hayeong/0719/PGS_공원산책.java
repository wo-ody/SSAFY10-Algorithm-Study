import java.util.Arrays;

public class 공원산책 {
    char[][] board;
    int n;
    int m;

    public int[] solution(String[] park, String[] routes) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        char[] dir = {'N', 'S', 'E', 'W'};
      
        int x = 0, y = 0;
        n = park.length;
        m = park[0].length();
      
        board = new char[park.length][];
        for (int i = 0; i < n; i++) {
            board[i] = park[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
      
        for (String route : routes) {
            char cmd = route.split(" ")[0].charAt(0);
            int dis = Integer.parseInt(route.split(" ")[1]);
            int nx = x;
            int ny = y;
            for (int i = 0; i < 4; i++) {
                if (cmd == dir[i]) {
                    boolean flag = true;
                    for (int j = 1; j <= dis; j++) {
                        nx = x + dx[i] * j;
                        ny = y + dy[i] * j;
                        if (!canGo(nx, ny)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
        return new int[]{x, y};
    }

    public boolean canGo(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (board[x][y] == 'X') {
            return false;
        }
        return true;
    }
}
