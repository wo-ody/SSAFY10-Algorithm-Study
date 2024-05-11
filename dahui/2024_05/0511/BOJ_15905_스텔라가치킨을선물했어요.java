import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15905_스텔라가치킨을선물했어요 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int problem = Integer.parseInt(st.nextToken());
			int penalty = Integer.parseInt(st.nextToken());
			arr[i][0] = problem;
			arr[i][1] = penalty;
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}else return o2[0] - o1[0];
		});

		int problem = arr[4][0];
		int cnt = 0;
		for (int i = 5; i < N; i++) {
			if (problem != arr[i][0]) break;
			cnt++;
		}
		System.out.println(cnt);
	}
}
