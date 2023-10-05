package ssafy.study.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305_주유소 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] road = new long[N - 1];
		long[] cost = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			road[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			cost[i] = Integer.parseInt(st.nextToken());

		long price = 0;
		long min_price = cost[0];

		for (int i = 0; i < N - 1; i++) { // 마지막 주유소에서는 기름을 넣지 않는다
			if (cost[i] < min_price) // 첫번째 주유소에서는 무조건 기름을 넣어야한다
				min_price = cost[i];

			price += min_price * road[i];
		}

		System.out.println(price);
	}
}
