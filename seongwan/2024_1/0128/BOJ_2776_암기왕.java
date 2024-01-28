import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//set에 넣어놓고 있는지 없는지 확인하면서 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static Set<Integer> note = new HashSet<>();

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			// set 초기화
			note.clear();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			// 수첩 1 내용을 set에 입력
			for (int i = 0; i < N; i++) {
				note.add(Integer.parseInt(st.nextToken()));
			}

			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			// 수첩 2내용을 수첩 1 내용과 비교
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (note.contains(num))
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			}
		}
		System.out.println(sb);
	}
}