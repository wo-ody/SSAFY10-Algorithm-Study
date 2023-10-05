import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {

	static int N, M;
	static boolean[][] map;
	static int[] p;
	static String ans = "YES";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		make();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int connect = Integer.parseInt(st.nextToken());
				if (connect == 1)
					union(i, j);
			}
		}
		// 도시들의 개수와 도시들 간의 연결 여부가 주어져 있고,
		// 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때 가능한지 여부를 판별하는 프로그램을 작성하시오.
		// 같은 도시를 여러 번 방문하는 것도 가능하다.!!!!!!!!!!!
		// 마지막 줄에는 여행 계획이 주어진다. 도시의 번호는 1부터 N까지 차례대로 매겨져 있다.

		st = new StringTokenizer(br.readLine());
		int firstPlan = find( Integer.parseInt(st.nextToken()) );
		for (int i = 0; i < M-1; i++) {
			// 해당 원소들이 같은 집합에 포함되어 있으면 YES, 아니면 NO
			int nextPlan = find( Integer.parseInt(st.nextToken()) );
			if(firstPlan != nextPlan) {
				ans = "NO";
				break;
			}
		}
		System.out.println(ans);
	}

	// 원소 생성
	static void make() {
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}

	// x를 포함하고 있는 집합(부모원소)을 찾는 함수
	static int find(int x) {
		// 못찾으면( 여전히 자기 자신이 부모원소 ) 자기 자신 return;
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

	// 합집합
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		p[py] = px;
	}

}
