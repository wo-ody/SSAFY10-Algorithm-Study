/*	
 *	7.28 김창희
 *	BOJ_17471_게리맨더링
 * 
 *	[틀린 풀이]
 *	1. 노드들을 연결하며 graph를 구성하면서 간선에 대한 정보도 따로저장한다
 *	2. 조합으로 간선들을 뽑아서 grpah에서 제외시키면서 bfs탐색
 *	3. 탐색을 하며 방문처리도 한다. 방문하는 수가 2초과이면 답이 될수 없다.
 *	4. 선택한 간선들을 검증하기위해 반복문을 돌리는 과정에서 시간초과 발생!
 * 
 *	[정답 풀이]
 *	1. 간선의 정보가 아니라 정점들을 선택한다.
 *	2. 무조건 두개의 그룹으로 나뉘어야 하기때문에 0과 1 그룸으로 정점들을 선택한다.
 *	3. 0과1의 대표 정점을 선택후 bfs를 진행한다.
 *	4. 이때, 같은 번호 그룹이지만 방문처리가 되지 않았다면 두개의 그룹으로 나뉘지 않는다는 것 이므로 answer = -1
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> grpah = new ArrayList<>();
	static int[] cost, partition;
	static int n, answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		cost = new int[n + 1];
		partition = new int[n + 1];
		for (int i = 0; i < n + 1; i++) grpah.add(new ArrayList<>());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) cost[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len; j++) {
				grpah.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 1; i < n; i++) comb(1, i);
		
		System.out.println(Integer.MAX_VALUE == answer ? -1 : answer);
	}

	static void comb(int start, int len) {
		if (len == 0) {
			int p1 = 0, p2 = 0;
			for (int i = 1; i < n + 1; i++) {
				if (partition[i] == 0)
					p1 = i;
				if (partition[i] == 1)
					p2 = i;
			}
				
			if (p1 == p2 || !bfs(p1) || !bfs(p2)) return;
			
			int result = 0;
			for (int i = 1; i < n + 1; i++) {
				if (partition[i] == 1) {
					result += cost[i];
				} else {
					result -= cost[i];
				}
			}
			
			answer = Math.min(answer, Math.abs(result));
			return;
		}
		
		for (int i = start; i < n+1; i++) {
			partition[i] = 1;
			comb(i + 1, len-1);
			partition[i] = 0;
		}
	}

	static boolean bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[n + 1];

		q.offer(start);
		v[start] = true;

		while (!q.isEmpty()) {
			int i = q.poll();

			for (int ni : grpah.get(i)) {
				if (!v[ni] && partition[start] == partition[ni]) {
					v[ni] = true;
					q.offer(ni);
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			if (!v[i] && partition[i] == partition[start]) return false;
		}
		return true;
	}
}
