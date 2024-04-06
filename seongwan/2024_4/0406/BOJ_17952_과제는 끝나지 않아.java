//과제의 점수와 걸리는 시간을 노드로 저장한다.
//과제를 수행하다가 다른 과제가 들어오면 현재 진행 중인 과제의 노드를
//스택에 담는다.
//1초마다 수행 중인 과제의 상태를 업데이트 한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static class node {
		int score;
		int time;

		public node(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<node> stack = new ArrayDeque<>();
	static int N, ans;
	static node temp;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 0) {
				if (temp != null) {
					temp.time--;
					if (temp.time == 0) {
						ans += temp.score;
						if (!stack.isEmpty())
							temp = stack.pop();
						else
							temp = null;
					}
				}
			}

			if (cmd == 1) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken()) - 1;

				if (time == 0) {
					ans += score;
					continue;
				}

				if (temp != null) {
					stack.push(temp);
				}

				temp = new node(score, time);
			}
		}
		System.out.println(ans);
	}
}