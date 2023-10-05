import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_4013_특이한자석 {

    static int[][] magnet = new int[5][8]; // 자석 정보 (row 0 dummy)
    static int n; // 자석 돌릴(명령어) 횟수

    static ArrayList<ArrayList<Integer>> graph; // 자석 간 접합 정보 저장
    static boolean[] visited; // dfs 방문체크

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // n입력
            n = Integer.parseInt(br.readLine());

            // 자석 정보 입력
            for (int i = 1; i <= 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 접합 여부 저장
            updateConnection();

            // 명령어 n개를 입력 받고 각 명령어에 대한 수행
            for (int c = 0; c < n; c++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                dfs(num, dir); // 연쇄적으로 돌리고(dfs)!!

                // connect 업데이트(접합 여부 저장)
                updateConnection();
            }


            // magnet의 0번쨰 col을 보며 점수 계산
            int sum = 0;
            for (int i = 1; i <= 4; i++) {
                if (magnet[i][0] == 1) {
                    sum += Math.pow(2, i - 1);
                }
            }
            sb.append("#").append(t).append(" ").append(sum).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void updateConnection() {
        visited = new boolean[5];
        graph = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            graph.add(new ArrayList<>());
        }
        // 앞 자석의 2번째 돌기와 뒷자석의 6번째 돌기가 서로 마주함
        for (int i = 1; i <= 3; i++) {
            if (magnet[i][2] != magnet[i + 1][6]) { // 서로 다른 극이면 연쇄적으로 회전함
                graph.get(i).add(i + 1);
                graph.get(i + 1).add(i);
            }
        }
    }

    static void dfs(int num, int dir) { // dfs(연쇄적으로 자석을 돌림)
        rotate(num, dir); // 방향에 따라 자석 돌리고
        visited[num] = true; // 방문 체크

        for (int i : graph.get(num)) { // 인접한 자석들에 대해
            if (!visited[i]) { // 방문한적 없으면
                dfs(i, dir * -1); // 연쇄적으로, 현재 방향과 반대방향으로 자석 돌림
            }
        }

    }

    static void rotate(int num, int dir) {
        if (dir == 1) { // 시계 방향(오른쪽으로 1칸 밈)
            int tmp = magnet[num][7]; // 마지막 정보를 맨 앞으로 저장하기 위해 임시로 저장
            for (int i = 7; i >= 1; i--) { // 0~6까지 오른쪽으로 1칸 밈
                magnet[num][i] = magnet[num][i - 1];
            }
            magnet[num][0] = tmp; // 마지막 정보 맨앞에 저장
        } else if (dir == -1) { // 반시계 방향 (왼쪽으로 1칸 밈)
            int tmp = magnet[num][0]; // 맨 처음 정보를 맨 뒤에 저장하기 위해 임시로 저장
            for (int i = 0; i <= 6; i++) { // 1~7까지 왼쪽으로 1칸 밈
                magnet[num][i] = magnet[num][i + 1];
            }
            magnet[num][7] = tmp; // 맨 처음 정보를 맨 뒤에 저장
        }
    }
}
