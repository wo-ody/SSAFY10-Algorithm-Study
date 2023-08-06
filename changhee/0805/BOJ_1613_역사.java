/*
 *	08.05 김창희
 *	BOJ_1613_역사
 *
 *  [틀린 풀이]
 *  작업의 순서를 물어보는것이므로 위상정렬로 생각.
 *  일의 선후관계를 위상정렬로 뽑으면서 앞에 몇개의 일을 해야 해당 일을 수행할수있는지 카운트한다.
 *  또한 서로 다른 집합이라면 위상정렬이 의미 없으므로 유니온 파인드로 동일한 집합인지 판단한다.
 *  하지만..! 같은 집합이라도 {1 2}, {1 3}, {3 4}일 경우 2와 4의 우선순위를 따질수없따!
 *
 *	[맞는 풀이]
 *  1. 같은 그래프라도 위상정렬로 우선순위를 알 수 없는 경우가 존재한다.
 *  2. 간선의 정보를 입력받은 인접행렬 배열을 바탕으로, A와 B가 중간 노드를 거쳐 연결되어 있는지를 판단하기 위해 플로이드 알고리즘을 사용한다.
 *  3. 두 정점이 중간노드를 거쳐도 이어지지 않는다면 INF로 설정하고 연결되어 있으면 몇개의 노드를 거치는지(우선순위)를 기록한다.
 *  4. dist[x][y]와 dist[y][x]모두가 INF 라면 상관이 없는 정점들이고, dist[y][x]만 INF라면 x y순으로 작업이 수행, dist[x][y]가 INF라면 y x순으로 작업이 수행된다는 것이다.
 *  5. 4번의 조건으로 답을 구할 수 있는 이유는 작업의 전 후 관계가 명확하기 때문이다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int INF = Integer.MAX_VALUE;

        int[][] info = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            info[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
        }


        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (info[i][j] > 0) dist[i][j] = info[i][j];
                else if (i != j && info[i][j] == 0) dist[i][j] = INF;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int x = 1; x < n + 1; x++) {
                for (int y = 1; y < n + 1; y++) {
                    if (dist[x][i] == INF || dist[i][y] == INF) continue;
                    dist[x][y] = Math.min(dist[x][y], dist[x][i] + dist[i][y]);
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            if(dist[x][y] == INF && dist[y][x]==INF) answer.append(0);
            else if (dist[y][x] == INF) answer.append(-1);
            else if (dist[x][y] == INF) answer.append(1);
            answer.append("\n");
        }

        System.out.println(answer);

    }
}
