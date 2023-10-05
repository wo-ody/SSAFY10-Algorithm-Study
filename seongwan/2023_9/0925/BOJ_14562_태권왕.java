import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int C;
	static StringBuilder sb = new StringBuilder();
	static int S, T;

	public static void main(String[] args) throws Exception {
		C = Integer.parseInt(br.readLine());
		for (int t = 0; t < C; t++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());

			bfs();
		}
		System.out.println(sb);
	}

	static void bfs() {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { S, T });
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int cs = cur[0];
				int ct = cur[1];
				if (cs == ct) {
					sb.append(cnt + "\n");
					return;
				}
				int ns = 2 * cs;
				int nt = ct + 3;
				if (ns <= nt)
					queue.add(new int[] { 2 * cs, ct + 3 });// A
				ns = cs + 1;
				if (ns <= ct)
					queue.add(new int[] { ns, ct });// B

			}

			cnt++;

		}
	}

}
