package algorithm2024.mar.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_7785_회사에있는사람 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		TreeSet<String> set = new TreeSet<>((o1,o2)->o2.compareTo(o1));

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			boolean isEnter = st.nextToken().equals("enter");
			if (isEnter) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}

		for (String s : set) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);

	}
}
