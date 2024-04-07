import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17952_과제는끝나지않아 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;

		Deque<int[]> stack = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken())-1;
				if (time == 0) {
					sum += score;
				}else {
					stack.push(new int[] {score, time});
				}
			}else {
				if (!stack.isEmpty()){
					int[] arr = stack.pop();
					arr[1] -= 1;
					if (arr[1] == 0) {
						sum += arr[0];
					}else {
						stack.push(arr);
					}
				}
			}
		}

		System.out.println(sum);

	}
}
