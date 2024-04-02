import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_28446_볼링공찾아주기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num ==  1) {
				int x = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				map.put(w, x);
			}else {
				int w = Integer.parseInt(st.nextToken());
				sb.append(map.get(w)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
