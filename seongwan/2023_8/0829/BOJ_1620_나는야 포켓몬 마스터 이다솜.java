import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static Map<Integer, String> map = new HashMap<>();
	static Map<String, Integer> map1 = new HashMap<>();

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			map.put(i, name);
			map1.put(name, i);
		} // 포켓몬 도감 입력

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			try {
				int num = Integer.parseInt(s);
				sb.append(map.get(num) + "\n");//입력이 숫자일 땐 포켓몬 이름 출력
			} catch (Exception e) {
				sb.append(map1.get(s) + "\n");//입력이 문자일 땐 포켓몬 번호 출력
			}
		}
		System.out.println(sb);

	}

}
