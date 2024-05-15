import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static final String dup = "GRESKA";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();
		int[] count = new int[] {13, 13, 13, 13}; // P, K, H, T

		String s = br.readLine();

		for (int i = 0; i < s.length() / 3; i++) {
			String temp = s.substring(i * 3, (i + 1) * 3);

			if (set.contains(temp)) {
				System.out.println(dup);
				return;
			} else {
				set.add(temp);
			}
		}

		for (String string : set) {
			if (string.charAt(0) == 'P') {
				count[0]--;
			} else if (string.charAt(0) == 'K') {
				count[1]--;
			} else if (string.charAt(0) == 'H') {
				count[2]--;
			} else if (string.charAt(0) == 'T') {
				count[3]--;
			}
		}
		for (int i : count) {
			System.out.print(i + " ");
		}
	}
}