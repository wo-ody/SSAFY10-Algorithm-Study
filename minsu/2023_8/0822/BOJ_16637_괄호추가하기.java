package bj.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_16637_괄호추가하기 {
	static int n;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		String t = br.readLine();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				num.add(t.charAt(i) - '0');
			} else {
				op.add(t.charAt(i));
			}
		}
		
		int start = num.get(0);
		
		dfs(0, start);
		
		System.out.println(max);
	}

	public static void dfs(int now, int sum) {
		if (now >= op.size()) {
			max = Math.max(max, sum);
			return;
		}
		// 1. 괄호 안치고 진행하기
		int one = cal(now, sum, num.get(now + 1));
		dfs(now + 1, one);
		// 2. 괄호 치고 진행하기
		if (now + 1 < op.size()) { // 인덱스 범위 오류를 제거하기 위해
			int two = cal(now + 1, num.get(now + 1), num.get(now + 2));
			int result = cal(now, sum, two);
			dfs(now + 2, result);
		}
	}

	public static int cal(int op_idx, int a, int b) {
		switch (op.get(op_idx)) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return 1;
	}
}
