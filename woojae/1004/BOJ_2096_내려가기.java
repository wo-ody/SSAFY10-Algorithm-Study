import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] max_arr;
	static int[][] min_arr;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		max_arr = new int[n][3];
		min_arr = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				max_arr[i][j] = Integer.parseInt(st.nextToken());
				min_arr[i][j] = max_arr[i][j];
			}
		}
		System.out.println(solve(max_arr, true) + " " + solve(min_arr, false));
	}

	static int solve(int[][] arr, boolean flag) {  // 문제 그대로 직관적으로 풀면 되는 문제
		for (int i = 1; i < n; i++) {
			if (flag) {
				arr[i][0] += Math.max(arr[i - 1][0], arr[i - 1][1]);
				arr[i][1] += Math.max(Math.max(arr[i - 1][0], arr[i - 1][1]), arr[i - 1][2]);
				arr[i][2] += Math.max(arr[i - 1][1], arr[i - 1][2]);
			}
			else {
				arr[i][0] += Math.min(arr[i - 1][0], arr[i - 1][1]);
				arr[i][1] += Math.min(Math.min(arr[i - 1][0], arr[i - 1][1]), arr[i - 1][2]);
				arr[i][2] += Math.min(arr[i - 1][1], arr[i - 1][2]);
			}
		}
		return flag ? Arrays.stream(arr[n - 1]).max().getAsInt() : Arrays.stream(arr[n - 1]).min().getAsInt();
	}
}
