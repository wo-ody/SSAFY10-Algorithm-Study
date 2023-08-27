import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int result = 0;

		Stack<Integer> stack = new Stack<>();

		for (int k = 0; k < K; k++) {
			int temp = sc.nextInt();
			if (temp != 0)
				stack.push(temp);
			else
				stack.pop();
		}

		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		System.out.println(result);
	}
}
