package algorithm2023.dec.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2179_비슷한단어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static Map<String, Integer> map = new HashMap<>();
	static ArrayList<String> strList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (strList.contains(str))
				continue;
			map.put(str, i);
			strList.add(str);
		}
		int max = 0;
		int a = 0;
		int b = 0;
		String str1 = "";
		String str2 = "";

		List<String> list = new ArrayList<>(map.keySet());
		list.sort((s1, s2) -> s1.compareTo(s2));

		for (int i = 0; i < N - 1; i++) {
			for (int k = i + 1; k < N; k++) {
				int len = 0;
				String s1 = list.get(i);
				String s2 = list.get(k);
				for (int j = 0; j < Math.min(list.get(i).length(), list.get(k).length()); j++) {
					if (s1.charAt(j) != s2.charAt(j)) {
						break;
					}
					len++;
				}
				if (len >= max) {
					int[] idx = { map.get(s1), map.get(s2) };
					Arrays.sort(idx);
					if (len == max) {
						if (idx[0] == a) {
							if (idx[1] < b) {
								a = idx[0];
								b = idx[1];
							}
						} else if (idx[0] < a) {
							a = idx[0];
							b = idx[1];
						}
					} else {

						a = idx[0];
						b = idx[1];
					}
					max = len;
				}
			}
		}
		System.out.println(strList.get(a));
		System.out.println(strList.get(b));

	}
}
