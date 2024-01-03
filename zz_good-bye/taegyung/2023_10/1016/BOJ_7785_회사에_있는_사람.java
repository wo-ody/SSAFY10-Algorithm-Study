package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_7785_회사에_있는_사람 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Set<String> people = new HashSet<>();
		for (int log = 0; log < n; log++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String command = st.nextToken();
			if (command.equals("enter")) {
				people.add(name);
			} else {
				people.remove(name);
			}
		}

		// TODO 사전 역순으로 출력하는 것
//		System.out.println(people);
		ArrayList<String> dict = new ArrayList<>(people);
//		System.out.println(dict);
		Collections.sort(dict, (o1, o2) -> {
			return o2.compareTo(o1);
		});
//		System.out.println(dict);a
		StringBuilder sb = new StringBuilder();
		for (String s : dict) {
//			System.out.println(s);
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}
