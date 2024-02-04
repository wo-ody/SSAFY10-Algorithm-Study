import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//배열에 부모 노드의 번호를 기입
//주어지는 두 노드의 부모들을 인덱스로 따라가며 스택에 저장
//스택에서 루트부터 꺼내면서 부모가 달라지기 전까지 같았던 부모들을 찾음으로써
//두 노드의 가장 가까운 공통 조상을 찾음
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	static int commonAncestor;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];//0은 더미
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				parent[c] = p;
			}

			//공통 조상을 찾을 두 노드
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			Deque<Integer> ancestor1 = new ArrayDeque<>();
			Deque<Integer> ancestor2 = new ArrayDeque<>();
			findAncestor(n1, ancestor1);
			findAncestor(n2, ancestor2);

			//한 쪽의 스택이 비거나 다른 숫자가 나올 때까지 탐색
			while (!ancestor1.isEmpty() && !ancestor2.isEmpty()) {
				int p1 = ancestor1.pop();
				int p2 = ancestor2.pop();

				if (p1 == p2) {
					commonAncestor = p1;
				} else {
					break;
				}
			}
			sb.append(commonAncestor + "\n");
		}
		System.out.println(sb);
	}

	static void findAncestor(int node, Deque<Integer> stack) {
		int p = node;

		//루트를 지나 0에 도달하면 종료
		while (p != 0) {
			stack.push(p);
			p = parent[p];
		}
	}
}