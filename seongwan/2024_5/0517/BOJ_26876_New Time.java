import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int startH, startM, endH, endM, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		startH = Integer.parseInt(st.nextToken());
		startM = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), ":");
		endH = Integer.parseInt(st.nextToken());
		endM = Integer.parseInt(st.nextToken());

		bfs();

		System.out.println(ans);
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[2400];
		queue.add(new int[] { startH, startM });
		visit[startH * 100 + startM] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] temp = queue.poll();
				int H = temp[0];
				int M = temp[1];

				if (H == endH && M == endM) {
					return;
				}

				int nH = H + 1;
				int nM = M + 1;

				nH = nH == 24 ? 0 : nH;

				if (!visit[nH * 100 + M]) {
					visit[nH * 100 + M] = true;
					queue.add(new int[] { nH, M });
				}

				if (nM == 60) {
					if (!visit[nH * 100])
						visit[nH * 100] = true;
					queue.add(new int[] { nH, 0 });
				} else {
					if (!visit[H * 100 + nM])
						visit[H * 100 + nM] = true;
					queue.add(new int[] { H, nM });
				}
			}
			ans++;
		}
	}
}