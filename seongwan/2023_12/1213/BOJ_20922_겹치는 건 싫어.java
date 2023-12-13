import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K, start, ans;
	static StringTokenizer st;
	static Queue<Integer>[] nums = new Queue[1000001];

	public static void main(String[] args) throws Exception {
		for (int i = 1; i <= 100000; i++) {
			nums[i] = new ArrayDeque<>();
		}

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums[num].add(i);
			if (nums[num].size() > K) {
				ans = Math.max(ans, i - start);// 개수가 넘어갔을 때 그 전까지의 길이
				int temp = nums[num].poll();
				if (temp >= start)// 꺼낸 인덱스가 현 시작점 뒤에 있을 때만 시작점 변경
					start = temp + 1;// 개수가 넘어간 그 수의 제일 앞 인덱스 다음을 시작점으로 하고 다시 탐색 시작
			}
		}
		ans = Math.max(ans, N - start);

		System.out.println(ans);
	}
}