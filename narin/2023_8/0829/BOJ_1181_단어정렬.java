import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}

		Arrays.sort(word, new Comparator<String>() {

			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}

		});

		System.out.println(word[0]);
		for (int i = 1; i < N; i++) {
			if (!word[i].equals(word[i - 1])) {
				System.out.println(word[i]);
			}
		}
	}
}
