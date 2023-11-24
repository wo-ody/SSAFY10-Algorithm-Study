package month10.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터이다솜 {

	static int N, M;

	static Map<String, Integer> map = new HashMap<>();
	static String[] mapInt;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		mapInt = new String[N + 1];

		for (int i = 1; i < N + 1; i++) {
			String str = br.readLine();
			map.put(str, i);
			mapInt[i] = str;
		}

		while (M-- > 0) {
			String str = br.readLine();
			if (isNum(str)) {
				int index = Integer.parseInt(str);
				sb.append(mapInt[index]);
			} else {
				sb.append(map.get(str));
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static boolean isNum(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
