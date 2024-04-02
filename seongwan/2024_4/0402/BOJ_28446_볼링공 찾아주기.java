import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//맵을 사용해 저장
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<Integer, Integer> map = new HashMap<>();
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());

			if (query == 1) {
				int x = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				map.put(w, x);
			}
			if (query == 2) {
				int w = Integer.parseInt(st.nextToken());
				sb.append(map.get(w)).append("\n");
			}
		}
		System.out.println(sb);
	}
}