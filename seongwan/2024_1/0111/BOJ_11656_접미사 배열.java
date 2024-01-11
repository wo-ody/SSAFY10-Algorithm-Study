import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//substring으로 구한 접미사 배열을 pq에 넣고 꺼내면서 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String S;
	static PriorityQueue<String> pq = new PriorityQueue<>((e1, e2) -> e1.compareTo(e2));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		S = br.readLine();
		pq.add(S);
		for (int i = 1; i < S.length(); i++) {
			pq.add(S.substring(i));
		}
		while (!pq.isEmpty()) {
			sb.append(pq.poll() + "\n");
		}
		System.out.println(sb);
	}
}