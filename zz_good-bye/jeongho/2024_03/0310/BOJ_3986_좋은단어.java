package algorithm2024.mar.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_3986_좋은단어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			Deque<String> st = new ArrayDeque<>();
			String[] s = br.readLine().split("");
			for (String string : s) {
				if (!st.isEmpty() && st.peekLast().equals(string)) {
					st.removeLast();
				} else {
					st.addLast(string);
				}
			}
			if (st.isEmpty())
				cnt++;
		}
		System.out.println(cnt);
	}
}
