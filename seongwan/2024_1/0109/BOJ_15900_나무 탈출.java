import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//루트 노드에서 각 리프노드까지 거치는 노드 수를 dfs를 통해 체크한 뒤
//홀수면 성원이가 이기는 Yes ,짝수면 형석이가 이기는 No를 출력하면 해결 될 거 같음
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, sum;
	static List<Integer>[] tree;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		tree = new List[N + 1];
		visit = new boolean[N + 1];

		// 트리 초기화
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		// 트리 정보 입력
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree[from].add(to);
			tree[to].add(from);
		}

		// 루트 노드에서 dfs탐색 시작
		visit[1] = true;
		dfs(1, 0);
		// 짝수,홀수 여부에 따라 출력
		System.out.println(sum % 2 == 0 ? "No" : "Yes");

	}

	static void dfs(int num, int count) {
		if (num != 1 && tree[num].size() == 1)// 리프 노드인 경우
			sum += count;// 리프 노드까지 체크된 거쳐가는 노드 수를 저장
		else {
			for (Integer n : tree[num]) {
				if (!visit[n]) {
					visit[n] = true;
					// 다음 노드와 거쳐가는 노드 수를 체크
					dfs(n, count + 1);
					visit[n] = false;// 방문 처리 후 원복
				}
			}
		}
	}
}