import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//map으로 이름마다 상태를 관리하면서 춤 추는 인원을 체크하면 될 거 같음
//ChongChong 은 true로 두고 시작
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Map<String, Boolean> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		map.put("ChongChong", true);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();

			boolean b1 = map.getOrDefault(s1, false);
			boolean b2 = map.getOrDefault(s2, false);

			//둘다 true이거나 둘 다 false인 경우
			if ((b1 && b2) || !(b1 || b2)) {
				continue;
			}//춤추는 사람을 만난 경우
			else {
				cnt++;
				map.put(s1, true);
				map.put(s2, true);
			}
		}
		System.out.println(cnt);
	}
}