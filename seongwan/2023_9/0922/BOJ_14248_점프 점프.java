import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, s, stone[], cnt = 1;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());

		stone = new int[n + 1];// 0은 더미
		visit = new boolean[n + 1];// 0은 더미

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			stone[i] = Integer.parseInt(st.nextToken());
		}

		s = Integer.parseInt(br.readLine());

		visit[s] = true;
		dfs(s);
		System.out.println(cnt);
	}

	static void dfs(int x) {
		int px = x - stone[x];
		if (cango(px)) {
			visit[px] = true;
			cnt++;
			dfs(px);

		}
		int nx = x + stone[x];
		if (cango(nx)) {
			visit[nx] = true;
			cnt++;
			dfs(nx);

		}
	}

	static boolean cango(int x) {
		if (x >= 1 && x <= n && !visit[x])
			return true;
		return false;
	}

}
