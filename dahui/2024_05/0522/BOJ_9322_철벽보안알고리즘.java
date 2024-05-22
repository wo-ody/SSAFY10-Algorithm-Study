import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9322_철벽보안알고리즘 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			int[] basic = new int[N];
			for (int j = 0; j < N; j++) {
				String key = st.nextToken();
				map.put(key, j);
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				String key = st.nextToken();
				basic[j] = map.get(key);
			}
			st = new StringTokenizer(br.readLine());
			String[] ans = new String[N];
			for (int j = 0; j < N; j++) {
				ans[basic[j]] = st.nextToken();
			}
			for (int j = 0; j < N; j++) {
				sb.append(ans[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

