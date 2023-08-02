import java.util.Arrays;
import java.util.Scanner;

public class 미로만들기 {
    static int n;
    static String str;

    static char[][] board = new char[101][101]; // 최대입력이 50이므로

    // 남 서 북 동
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        str = sc.next();

        // 보드 초기화
        for(char[] row : board){
            Arrays.fill(row, '#');
        }

        int startX, startY, minX, minY, maxX, maxY; // 결과 보드 출력을 위한 min, max 좌표들
        startX = startY = minX = minY = maxX = maxY = 50; // 최대 입력이 50이므로 중간점 50을 시작점으로 함.
        board[startX][startY] = '.'; // 시작점 표시

        int dir = 0; // 첫 방향은 남쪽
        for (int i = 0; i < n; i++) {

            if(str.charAt(i) == 'F'){
                startX = startX+dx[dir];
                startY = startY+dy[dir];
                board[startX][startY] = '.';
                minX = Math.min(minX, startX);
                maxX = Math.max(maxX, startX);
                minY = Math.min(minY, startY);
                maxY = Math.max(maxY, startY);
            } else if(str.charAt(i) == 'R'){
                dir = (dir+1) %4;
            } else if(str.charAt(i) == 'L'){
                dir = (dir+3) %4;
            }
        }

        for(int i = minX; i<=maxX; i++){
            for(int j = minY; j<=maxY; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
