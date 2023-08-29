import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] point = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(point, (a, b) -> {

			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				return a[0] - b[0];
			}

		});

		for (int i = 0; i < N; i++) {
			sb.append(point[i][0] + " " + point[i][1] + "\n");
		}

		System.out.println(sb);
	}
}
