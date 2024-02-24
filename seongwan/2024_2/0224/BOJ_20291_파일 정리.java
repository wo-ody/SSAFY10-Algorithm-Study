import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

//.을 기준으로 StringTokenizer로 분리 해서 2번째 토큰의 값을 들고옴으로써 파일의 확장자를 얻고
//treemap에 확장자를 키로 개수를 값에 담은 후 정렬된 키 값을 기준으로 개수를 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static TreeMap<String, Integer> files = new TreeMap<>();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), ".");

			// 파일의 이름은 그냥 무시
			st.nextToken();
			String key = st.nextToken();

			// 기존에 맵에 없다면
			if (!files.containsKey(key)) {
				files.put(key, 1);
			} // 기존에 맵에 있었다면
			else {
				files.put(key, files.get(key) + 1);
			}
		}

		for (String key : files.keySet()) {
			sb.append(key + " " + files.get(key) + "\n");
		}
		System.out.println(sb);
	}
}