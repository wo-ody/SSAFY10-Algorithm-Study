import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] count;
	static int n;
	static StringBuilder sb = new StringBuilder();
	static final String no = "Not a pangram";
	static final String one = "Pangram!";
	static final String two = "Double pangram!!";
	static final String three = "Triple pangram!!!";

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			count = new int[26];
			String s = br.readLine().toLowerCase();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) - 'a' >= 0 && s.charAt(j) - 'a' <= 25) {
					count[s.charAt(j) - 'a']++;
				}
			}
			Arrays.sort(count);
			sb.append("Case " + i + ": ");
			if (count[0] >= 3)
				sb.append(three);
			else if (count[0] == 2)
				sb.append(two);
			else if (count[0] == 1)
				sb.append(one);
			else
				sb.append(no);

			sb.append("\n");
		}
		System.out.println(sb);
	}
}