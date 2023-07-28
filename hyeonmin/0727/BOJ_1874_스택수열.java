import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();
		int num = 1; // 오름차순 할 변수
		boolean result = true;
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < A.length; i++) {
			int su = A[i];
			if (su >= num) {
				while (su >= num) {
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			} else {
				int n = stack.pop();
				if(n > su) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		}
		if(result) System.out.println(bf.toString());

	}

}
