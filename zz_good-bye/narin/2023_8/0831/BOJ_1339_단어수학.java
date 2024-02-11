import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int size = str.length() - 1;
			for (int j = 0; j < str.length(); j++) {
				alpha[str.charAt(j) - 'A'] += (int) Math.pow(10, size - j);
			}
		}

		Arrays.sort(alpha);

		int value = 9;
		int index = alpha.length - 1;

		int max = 0;

		while (alpha[index] != 0) {
			max += alpha[index] * value;
			index--;
			value--;
		}

		System.out.println(max);

	}
}
