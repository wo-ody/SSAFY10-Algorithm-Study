import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_25418_정수a를k로만들기 {
	static int A,K,ans;
	static boolean[] visit = new boolean[2000001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(A);
		System.out.println(ans);
	}

	public static void bfs(int n) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{n, 0});

		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int num = arr[0];
			int d = arr[1];
			if (num == K) {
				ans = d;
				return;
			}
			if (!visit[num+1] && num+1 <= K) {
				q.add(new int[]{num+1, d+1});
				visit[num+1] = true;
			}
			if (!visit[num*2] && num*2 <= K) {
				q.add(new int[]{num*2, d+1});
				visit[num*2] = true;
			}
		}
	}
}
