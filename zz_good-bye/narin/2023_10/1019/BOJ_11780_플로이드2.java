import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int n, m;
	private static int def = 923456;
	private static int[][] bus;
	private static List<Integer>[][] route;
	private static StringBuilder sb;

	private static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (bus[i][k] + bus[k][j] < bus[i][j]) {
						bus[i][j] = bus[i][k] + bus[k][j];
						through(i, k, j);
					}
				}
			}
		}
	}

	private static void through(int i, int k, int j) {
		// 원래 루트를 다 지워줌
		route[i][j].clear();

		// i ~ k 까지 가는 루트를 추가
		for (int r : route[i][k]) {
			route[i][j].add(r);
		}

		// k 루트를 추가
		route[i][j].add(k);

		// k ~ j 까지 가는 루트를 추가
		for (int r : route[k][j]) {
			route[i][j].add(r);
		}
	}

	private static void printN() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (bus[i][j] == def) {
					sb.append(0).append(" ");
					continue;
				}
				sb.append(bus[i][j] + " ");
			}
			sb.append("\n");
		}
	}

	private static void printNN() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || bus[i][j] == def)
					sb.append(0).append("\n");
				else {
					sb.append(route[i][j].size() + 2).append(" ");
					sb.append(i).append(" ");
					for (int r : route[i][j]) {
						sb.append(r + " ");
					}
					sb.append(j).append("\n");
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		bus = new int[n + 1][n + 1];
		route = new ArrayList[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				route[i][j] = new ArrayList<>();
				if (i != j) {
					bus[i][j] = def;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// 버스 시작 도시 a, 도착 도시 b, 필요한 비용 c

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			bus[a][b] = Math.min(bus[a][b], c);
		}

		floyd();

		// n 줄 출력
		printN();

		// n*n 출력
		printNN();

		System.out.println(sb);
	}
}
