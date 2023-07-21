package jul_2023;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_BOJ15666_0721 {

	static int N, M, arr[], ans[];
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("C:\\SSAFY\\SSAFY_LIVE\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = new int[N];
		ans = new int[M];
		v = new boolean[N];
		s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		dfs(0, 0);

		System.out.println(sb);

	}

	static void dfs(int idx, int cnt) {
		if (cnt == M) {
			for (int n : ans) {
				sb.append(n + " ");
			}
			sb.append("\n");
		} else {
			int before = 0;
			for (int i = idx; i < N; i++) {
				if (arr[i] != before) {
					ans[cnt] = arr[i];
					before = arr[i];
					dfs(i, cnt + 1);
				}
			}
		}
	}
}
