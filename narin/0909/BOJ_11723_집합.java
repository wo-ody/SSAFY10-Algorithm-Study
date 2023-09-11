import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[21];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num;

			switch (order) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				arr[num] = 1;
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				arr[num] = 0;
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if (arr[num] == 1) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if (arr[num] == 1) {
					arr[num] = 0;
				} else {
					arr[num] = 1;
				}
				break;
			case "all":
				Arrays.fill(arr, 1);
				break;
			case "empty":
				Arrays.fill(arr, 0);
				break;

			}
		}

		System.out.println(sb);

	}
}
