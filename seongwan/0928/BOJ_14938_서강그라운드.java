import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, r, ans;
	static int[] item;
	static int[][] mat;
	static int INF = 1000000;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		mat = new int[n + 1][n + 1];
		item = new int[n + 1];// 0은 더미
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		} // 아이템 입력

		for (int i = 1; i <= n; i++) {
			Arrays.fill(mat[i], INF);
		} // 인접행렬 INF로 초기화

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			mat[a][b] = l;
			mat[b][a] = l;
		} // 인접 행렬 입력

		floyd();
		find();
		System.out.println(ans);

	}

	static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}
	}// 플로이드-워셜

	static void find() {
		for (int i = 1; i <= n; i++) {
			int temp = 0;
			temp += item[i];// 자기 지역 아이템 줍기
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;//사이클은 제외
				if (mat[i][j] <= m)
					temp += item[j];// 수색 범위 내 아이템 줍기
			}
			ans = Math.max(ans, temp);
		}
	}// 얻을 수 있는 아이템의 최대 개수를 찾아냄

}
