import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = 10000000;
	static int N, ans = INF, cnt;
	static int[][] mat;
	static boolean[] candi;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		mat = new int[N + 1][N + 1];// 0은 더미
		for (int i = 1; i <= N; i++) {
			Arrays.fill(mat[i], INF);
		} // INF로 인접 행렬 초기화

		while (true) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (from == -1)
				break;// 입력 종료
			mat[from][to] = 1;
			mat[to][from] = 1;
		} // 인접 행렬 입력

		floyd();
		find();
		sb.append(ans + " " + cnt + "\n");
		for (int i = 1; i <= N; i++) {
			if (candi[i])
				sb.append(i + " ");
		}
		System.out.println(sb);
	}

	static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}

	}

	static void find() {
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;// 본인 사이클 제외
				temp = Math.max(temp, mat[i][j]);
			}
			if (temp < ans) {// 회장의 회원점수 기준이 더 낮은 점수로 바뀔 때
				cnt = 1;// 회원 후보 인원수 초기화
				ans = temp;// 회장의 회원점수 변경
				candi = new boolean[N + 1];// 회장 후보 체크 초기화
				candi[i] = true;
			} else if (temp == ans) {
				cnt++;
				candi[i] = true;
			}
		}
	}

}
