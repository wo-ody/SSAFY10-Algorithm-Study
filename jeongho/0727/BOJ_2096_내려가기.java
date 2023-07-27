package algorithm2023.jul.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_BOJ2096 {
	static int N, max[], min[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = new int[3];
		min = new int[3];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			dp(i, s);
		}
		int ans1 = 0;
		int ans2 = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			ans1 = Math.max(ans1, max[i]);
			ans2 = Math.min(ans2, min[i]);
		}
		System.out.println(ans1 + " " + ans2);
	}

	static void dp(int i, String[] s) {
		int[] maxRet = new int[3];
		int[] minRet = new int[3];
		int n1 = Integer.parseInt(s[0]);
		int n2 = Integer.parseInt(s[1]);
		int n3 = Integer.parseInt(s[2]);
		
		maxRet[0] = Math.max(max[0], max[1])+n1;
		maxRet[1] = Math.max(max[0], Math.max(max[1], max[2]))+n2;
		maxRet[2] = Math.max(max[2], max[1])+n3;
		
		minRet[0] = Math.min(min[0], min[1])+n1;
		minRet[1] = Math.min(min[0], Math.min(min[1], min[2]))+n2;
		minRet[2] = Math.min(min[2], min[1])+n3;
		
		
		max = maxRet;
		min = minRet;

	}

	static boolean isValid(int i, int j) {
		if (i < 0 || j < 0 || i >= 3 || j >= 3)
			return false;
		return true;
	}
}