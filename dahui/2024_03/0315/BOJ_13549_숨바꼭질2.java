import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질2 {
	static int N,K,ans,cnt;
	static boolean[] visit = new boolean[2000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] {N, 0});
		visit[N] = true;

		while (!pq.isEmpty()) {
			int[] arr = pq.poll();
			visit[arr[0]] = true;
			if (arr[0] == K) {
				ans = arr[1];
				cnt++;
				while(!pq.isEmpty()) {
					arr = pq.poll();
					if (arr[1] == ans && arr[0] == K)cnt++;
				}
				break;
			}

			if (arr[0] < K) {
				if (arr[0]*2 <= 200000 && !visit[arr[0]*2]) {
					pq.add(new int[]{arr[0] * 2, arr[1] + 1});
				}
				if (arr[0]+1 <= 200000 && !visit[arr[0]+1]) {
					pq.add(new int[]{arr[0] + 1, arr[1] + 1});
				}
			}
			if (arr[0]-1 >= 0 && !visit[arr[0]-1]) {
				pq.add(new int[]{arr[0] - 1, arr[1] + 1});
			}
		}
		System.out.println(ans);
		System.out.println(cnt);
	}
}
