import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_15828_Router {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine()); // 라우터 크기
		while (true) {
			int p = Integer.parseInt(br.readLine());
			if (p == -1) break;
			if (p == 0) q.poll();
			else {
				if (q.size() != n) {
					q.add(p);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			sb.append(q.poll()).append(" ");
		}
		System.out.println(sb.length() == 0?"empty":sb);
	}
}
