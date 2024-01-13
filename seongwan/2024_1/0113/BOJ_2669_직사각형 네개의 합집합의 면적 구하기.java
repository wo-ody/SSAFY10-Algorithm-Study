import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//boolean 2차원 배열에 주어진 좌표 사이의 좌표를 false면 true로 바꾸면서 개수를 체크하고
//true라면 그냥 넘어감으로서 합집합의 좌표 개수를 구함
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int ans;
    static boolean[][] map = new boolean[101][101];

    public static void main(String[] args) throws Exception {
        //좌표값 입력
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            //왼쪽 아래 꼭짓점의 x좌표
            int startX = Integer.parseInt(st.nextToken());
            //왼쪽 아래 꼭짓점의 y좌표
            int startY = Integer.parseInt(st.nextToken());
            //오른쪽 위 꼭짓점의 x좌표
            int endX = Integer.parseInt(st.nextToken());
            //오른쪽 위 꼭짓점의 y좌표
            int endY = Integer.parseInt(st.nextToken());
            for (int j = startX; j < endX; j++) {
                for (int k = startY; k < endY; k++) {
                    if (!map[j][k]) {//체크가 되어 있지 않았던 경우
                        ans++;
                        map[j][k] = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}