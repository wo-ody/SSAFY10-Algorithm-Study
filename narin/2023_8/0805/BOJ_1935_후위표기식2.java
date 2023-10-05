package ssafy.study.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1935_후위표기식2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Double> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		String post = br.readLine();
		int size = post.length();

		Double[] num = new Double[N];
		for (int i = 0; i < N; i++) {
			num[i] = Double.parseDouble(br.readLine());

		}

		for (int i = 0; i < size; i++) {

			if (post.charAt(i) >= 'A' && post.charAt(i) <= 'Z') {
				stack.push((double) num[post.charAt(i) - 'A']);
			} else {
				double b = stack.pop();
				double a = stack.pop();

				switch (post.charAt(i)) {
				case '+':
					stack.push((double) (a + b));
					break;
				case '-':
					stack.push((double) (a - b));
					break;
				case '*':
					stack.push((double) (a * b));
					break;
				case '/':
					stack.push((double) (a / b));
					break;
				}

			}

		}

		if (stack.size() == 1) {
			double result = stack.pop();
			System.out.printf("%.2f", result);
		}
	}

}
