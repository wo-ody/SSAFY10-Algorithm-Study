import java.io.*;
import java.util.*;

public class Main {
	static String str[];
	static int N, M, Len, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		str = new String[N];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			str[i] = st.nextToken();
		}
		Len = M - 5;
		int visited = 0;
		visited |= 1 << ('a' - 'a');
		visited |= 1 << ('n' - 'a');
		visited |= 1 << ('t' - 'a');
		visited |= 1 << ('c' - 'a');
		visited |= 1 << ('i' - 'a');
		if (M < 5)
			answer = 0;
		else
			comb(0, visited, 0);
		System.out.println(answer);
	}

	static void comb(int dep, int visited, int start) {
		if (dep == Len) {
			isValid(visited);
			return;
		}
		for (int i = start; i < 26; i++) {
			if ((visited & 1 << i) == 0) {
				comb(dep + 1, visited | 1<<i, i+1);
			}
		}
	}

	static void isValid(int visited) {
		int ret = 0;
		boolean stop;
		for (String s : str) {
			int start = 4;
			int end = s.length() - start;
			stop = false;
			if (start != end) {
				char[] ch = s.substring(start, end).toCharArray();
				for (char c : ch) {
					int index = c- 'a';
					if ((visited & 1 << index) == 0) {
						stop = true;
						break;
					}
				}
			}
			if (!stop) {
				ret++;
			}
		}
		answer = Math.max(ret, answer);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
