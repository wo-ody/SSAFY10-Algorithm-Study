import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int[][] cities;
	static int[] plans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 받기.
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		cities = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cities[i][j] = Integer.parseInt(st.nextToken());
				if (i == j)
					cities[i][j] = 1;
			}
		}

		plans = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			plans[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		// 풀이 - 플로이드 와셜
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 자기 자신도 여행 가능.
					if (cities[i][k] == 1 && cities[k][j] == 1)
						cities[i][j] = 1;
				}
			}
		}

		// 필요한 변수 초기화.
		boolean possible = true;
		int start = plans[0];
		for (int i = 1; i < M; i++) {
			if (cities[start][plans[i]] == 0) {
				possible = false;
				break;
			}
		}

		// 정답 출력
		if (possible)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
