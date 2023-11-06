package algorithm2023.oct.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1863_스카이라인쉬운거 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());

		ArrayList<Pos> pos = new ArrayList<>();

		ArrayDeque<Pos> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pos.add(new Pos(x, y));
		}

		int cnt = 0;
		stack.add(new Pos(0,0));
		for (Pos p : pos) {
			if (stack.isEmpty()) {
				stack.push(p);
				continue;
			}
			if(p.y>stack.peekFirst().y) {
				cnt++;
				stack.push(p);
				continue;
			}
			
			while (!stack.isEmpty() && stack.getFirst().y > p.y) {
				stack.pop();
			}

			if(!stack.isEmpty()&&stack.getFirst().y<p.y) {
				cnt++;
			}
			
			stack.push(p);
			

		}
		
		System.out.println(cnt);

	}
}