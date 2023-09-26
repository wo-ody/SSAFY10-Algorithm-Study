import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, depth, size, num;
	static List<Integer>[] adlist;
	static int visit[];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new int[N + 1];
		adlist = new List[N + 1];// 0은 더미
		for (int i = 1; i <= N; i++) {
			adlist[i] = new ArrayList<>();
		} // 인접 리스트 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adlist[from].add(to);
			adlist[to].add(from);
		} // 간선 입력

		bfs();
		find();
		System.out.println(num + " " + (depth - 1) + " " + size);
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		visit[1] = -1;// 방문 처리
		depth = 0;
		while (!queue.isEmpty()) {
			depth++;
			size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				for (Integer to : adlist[cur]) {
					if (visit[to] == 0) {
						visit[to] = depth;
						queue.add(to);
					}
				}
			}
		}
	}

	static void find() {
		for (int i = 1; i <= N; i++) {
			if (visit[i] == depth - 1) {
				num = i;
				return;
			}
		}
	}

}
