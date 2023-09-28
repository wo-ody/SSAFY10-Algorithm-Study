import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k, s;
	static int[][] mat;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		mat = new int[n + 1][n + 1];// 0은 더미
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			mat[from][to] = 1;
		} // 인접 행렬 입력

		floyd();

		s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			find(from, to);
		}

		System.out.println(sb);

	}

	static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (mat[i][k] == 1 && mat[k][j] == 1)
						mat[i][j] = 1;
				}
			}
		}

	}

	static void find(int from, int to) {
		if (mat[from][to] == 1)
			sb.append(-1 + "\n");//앞의 사건이 먼저 일어난 경우
		else if (mat[to][from] == 1)
			sb.append(1 + "\n");//뒤의 사건이 먼저 일어난 경우
		else
			sb.append(0 + "\n");//순서를 알 수 없는 경우

	}

}
