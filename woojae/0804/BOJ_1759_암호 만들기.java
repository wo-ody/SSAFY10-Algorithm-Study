import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l, c; // l은 서브셋의 길이. c는 주어진 문자들의 개수
	static char[] problems;
	static char[] subset;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		problems = new char[c];
		subset = new char[l];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++)
			problems[i] = st.nextToken().charAt(0);
		Arrays.sort(problems);  // 사전순이라는 조건에 맞추기 위해 정렬
		search(0, 0);
		System.out.println(sb);

	}

	static void search(int idx, int target) {
		if (target == l) {  // 서브셋이 구성되었을 때
			if (valid()) {  // 유효한 서브셋이라면
				for (char c : subset)
					sb.append(c);
				sb.append("\n");
			}
			return;  // 추가 후 반환
		}
		if (idx == c)  // 모든 탐색이 끝났다면
			return;
		subset[target] = problems[idx];  // 해당 문자 선택
		search(idx + 1, target + 1);
		search(idx + 1, target);
	}

	static boolean valid() {
		int vowel = 0;  // 모음
		int consonant = 0;  // 자음
		for (char c : subset) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')  // 모음이라면
				vowel++;
			else  // 자음이라면
				consonant++;
		}

		return (vowel >= 1 && consonant >= 2) ? true : false;  // 제약 조건을 만족했다면 true 아니라면 false
	}
}
