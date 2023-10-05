package algorithm2023.jul.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1_BOJ9465 {
	static int n;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			String[] s1 = br.readLine().split(" ");
			String[] s2 = br.readLine().split(" ");
			int prev1 = Integer.parseInt(s1[0]);
			int prev2 = Integer.parseInt(s2[0]);
			
			for (int i = 1; i < n; i++) {
				int a = Integer.parseInt(s1[i]);
				int b = Integer.parseInt(s2[i]);
				int temp = prev1;
				prev1 = Math.max(prev2 + a, prev1);
				prev2 = Math.max(temp + b, prev2);

			}
			System.out.println(Math.max(prev1, prev2));

		}
	}
}
