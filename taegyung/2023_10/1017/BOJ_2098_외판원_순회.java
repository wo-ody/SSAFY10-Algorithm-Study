import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0001 -> 1번도시 방문
// 1010 -> 2,4도시 방문
// 1101 -> 1,3,4 도시 방문

// memoi[i][j] => 현재 i번 도시에 있고, 거쳐온 도시가 j일 때, 남은 도시를 방문하는 데 필요한 최소 비용

// memoi[3][1100101] => 1,3,6,7 도시를 거쳐 현재 3번 도시일 때 남은 2,4,5를 방문하는 데 드는 최소 비용
// for(int i = 1; i <= N ; i ++){
// 	Math.min(memoi[i][1<<i]);
public class Main {
	static int N, allMask, INF = 999_999_999;
	static int[][] W;
	static int[][] memoi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		W = new int[N][N];

		allMask = (1 << N) - 1; // N이 5면 1<<5 => 100000 ==> 1을 빼면 11111
		memoi = new int[N][allMask];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 1에서 출발한다고 했을 때

		System.out.println(tsp(0, 1));

	public static int tsp(int startNode, int mem) {
		if (mem == allMask) { // 방문 완료
			if (W[startNode][0] == 0)
				return Integer.MAX_VALUE / 2;
			return W[startNode][0]; 
		}
		if (memoi[startNode][mem] != 0)
			return memoi[startNode][mem];

		int min_route = Integer.MAX_VALUE / 2;
		for (int i = 1; i < N; i++) {

			if ((mem & (1 << i)) == 0 && W[startNode][i] != 0) { // 아직 방문하지 않았다.
				if (tsp(i, (mem | (1 << i))) + W[startNode][i] < min_route) {
					min_route = tsp(i, (mem | (1 << i))) + W[startNode][i];
				}
			}
		}
		return memoi[startNode][mem] = min_route;
	}
}
