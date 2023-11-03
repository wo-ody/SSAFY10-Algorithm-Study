import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, P, start, startv = Integer.MAX_VALUE;
	static int[] nation;
	static int[][] edgelist;
	static int parents[];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		edgelist = new int[P][3];
		nation = new int[N + 1];
		parents = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			nation[i] = Integer.parseInt(br.readLine());
			if (nation[i] < startv) {
				startv = nation[i];
				start = i;
			}
			// 비용이 제일 적은 나라가 시작점
		} // 국가별 비용 입력
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edgelist[i] = new int[] { from, to, 2 * cost + nation[from] + nation[to] };
		}

		Arrays.sort(edgelist, (e1, e2) -> e1[2] - e2[2]);// 간선 가중치 기준 오름차순 정렬
		make();

		int result = 0;// MST 비용
		int count = 0;// 연결된 간선 개수
		for (int[] e : edgelist) {
			if (union(e[0], e[1])) {
				result += e[2];
				if (++count == N - 1)
					break;
			}
		}
		System.out.println(result + nation[start]);
	}

	static void make() {
		parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {// 0은 더미
			parents[i] = i;// 모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다.(자신이 곧 대표자인 루트로 표현)
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;

	}

}