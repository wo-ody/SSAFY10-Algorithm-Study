import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, delete, ans, root;
	static List<Integer>[] tree;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		tree = new List[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		} // tree구조 초기화

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = i;
				continue;
			}
			tree[parent].add(i);
		}

		delete = Integer.parseInt(br.readLine());
		if (delete == root)
			System.out.println(0);
		else {
			bfs();
			System.out.println(ans);
		}
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int from = queue.poll();
			int cnt = 0;
			for (Integer to : tree[from]) {
				if (to == delete)
					continue;
				queue.add(to);
				cnt++;
			}
			if (cnt == 0) {
				ans++;
			}
		}
	}

}
