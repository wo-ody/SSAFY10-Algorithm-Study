// 스트링빌더 후기 : 쓸데없이 코드가 길고 귀찮다

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Deque<Integer> dq = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			switch (order) {
			case "push_front":
				int f = Integer.parseInt(st.nextToken());
				dq.addFirst(f);
				break;
			case "push_back":
				int b = Integer.parseInt(st.nextToken());
				dq.addLast(b);
				break;
			case "pop_front":
				if (!dq.isEmpty()) {
					sb.append(dq.pollFirst() + "\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case "pop_back":
				if (!dq.isEmpty()) {
					sb.append(dq.pollLast() + "\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case "size":
				sb.append(dq.size() + "\n");
				break;
			case "empty":
				if (dq.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "front":
				if (!dq.isEmpty()) {
					sb.append(dq.peekFirst() + "\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case "back":
				if (!dq.isEmpty()) {
					sb.append(dq.peekLast() + "\n");
				} else {
					sb.append("-1\n");
				}
				break;
			}
		}

		System.out.println(sb);

	}
}
