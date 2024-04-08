import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//플로이드 워셜을 이용해서 해당 노선에 최단 거리로 갈 수 있는
//k를 표기한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int INF = 100000000;
	static int N, M;
	static int[][] mat;
	static int[][] ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat = new int[N + 1][N + 1];
		ans = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			mat[from][to] = weight;
			mat[to][from] = weight;

			//바로 옆 길을 우선적으로 ans행렬에 기입
			ans[from][to] = to;
			ans[to][from] = from;
		}
		floyd();
		System.out.println(sb);
	}

	static void floyd() {
		//갈 수 없는 길 INF처리
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (mat[i][j] == 0)
					mat[i][j] = INF;
			}
		}

		//플로이드 워셜
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					//지나감으로써 최단 거리가 되는 k의 값이 있을 때
					if (i != j && i != k && k != j && mat[i][k] + mat[k][j] < mat[i][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
						ans[i][j] = ans[i][k];
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (mat[i][j] == INF)
					sb.append("-").append(" ");
				else
					sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}
}