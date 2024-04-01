import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1544_사이클단어 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				StringBuilder str2 = new StringBuilder();
				for (int k = 0; k < str.length(); k++) {
					str2.append(str.charAt((j + k) % str.length()));
				}
				if (set.contains(str2.toString())) {
					flag = true;
					break;
				}
			}

			if (!flag) set.add(str);
		}

		System.out.println(set.size());

	}
}
