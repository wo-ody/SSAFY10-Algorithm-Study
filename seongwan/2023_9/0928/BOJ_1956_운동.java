import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E;
	static int[][] mat;
	static int INF = 10000000;
	static int ans = INF;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		mat = new int[V + 1][V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			mat[a][b] = c;
		}

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (mat[i][j] == 0)
					mat[i][j] = INF;
			}
		} // 인접 행렬 입력

		floyd();
		find();
		System.out.println(ans == INF ? -1 : ans);
		// 갈 수 없어서 INF로 남아있다면 -1 아니라면 최소값 출력

	}

	static void floyd() {
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}
	}// 플로이드-워셜

	static void find() {
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j)
					ans = Math.min(ans, mat[i][j]);
				else
					ans = Math.min(ans, mat[i][j] + mat[j][i]);
			}
		}
	}// 사이클의 최단거리 중에서 최소값 확인

}
