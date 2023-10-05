import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] city;
	private static List<Node> house, chicken;
	private static Node[] pick;
	private static int result = Integer.MAX_VALUE;

	private static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static void comb(int count, int start) {

		if (count == M) {
			int sum = 0;

			for (int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int row = Math.abs(house.get(i).r - pick[j].r);
					int col = Math.abs(house.get(i).c - pick[j].c);

					if (row + col < min) {
						min = row + col;
					}
				}
				sum += min;
			}
			if (sum < result) {
				result = sum;
			}
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			pick[count] = chicken.get(i);
			comb(count + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		city = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		pick = new Node[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) {
					house.add(new Node(i, j));
				} else if (city[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}

		comb(0, 0);
		System.out.println(result);

	}
}
