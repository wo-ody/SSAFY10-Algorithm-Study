import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157_단어공부 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine().toUpperCase(); // 대문자로 변경
		int count[] = new int[26]; // 알파벳 개수

		for (int i = 0; i < input.length(); i++) {
			int num = input.charAt(i) - 'A';
			count[num]++;
		}
		int max = 0;
		char answer = '?';

		for (int i = 0; i < 26; i++) {
			if (max < count[i]) {
				max = count[i];
				answer = (char) (i + 'A');

			} else if (max == count[i]) {
				answer = '?';
			}
		}
		System.out.println(answer);
	}

}
