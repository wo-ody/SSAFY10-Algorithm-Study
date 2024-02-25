import java.io.BufferedReader;
import java.io.InputStreamReader;

//1번 조건은 문자들을 보며 모음의 개수를 체크
//2번 조건은 문자를 하나 하나 비교해가며 모음이나 자음을 처음 만난 순간부터 
//다음 모음 자음의 개수를 카운트하는 식으로 확인한다.
//3번 조건도 2번과 마찬가지로 한 글자씩 비교하면서 바로 다음 문자와 같은지 확인한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final String accept = " is acceptable.";
	static final String notaccept = " is not acceptable.";
	static char[] vowel = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) throws Exception {
		while (true) {
			String s = br.readLine();

			// end가 나오면 종료
			if (s.equals("end"))
				break;

			// 총 모음의 개수
			int vowelcnt = 0;
			// 연속되는 모음,자음의 개수
			int seqVowel = 0;
			int seqCon = 0;
			// 연속된 문자 확인을 위한 전 탐색 문자
			char prev = ' ';
			// accept 체크용
			boolean check = true;

			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);

				// 전 문자와 똑같은 문자가 나와서 연속일 때
				if (temp == prev) {
					// e와 o인 경우는 pass
					if (temp != 'e' && temp != 'o') {
						check = false;
						break;
					}
				}

				// 모음인지 체크용
				boolean vchk = false;
				for (int j = 0; j < 5; j++) {
					if (vowel[j] == temp) {
						vowelcnt++;
						seqVowel++;

						// 모음이 3개 연속으로 나올 때
						if (seqVowel == 3) {
							check = false;
							break;
						}

						// 연속된 자음 초기화
						seqCon = 0;

						vchk = true;
						break;
					}
				}

				// 모음 체크를 했는데 check가 false가 된 경우
				if (!check) {
					break;
				}

				// 모음 체크를 했을 때 모음이 아닌 경우
				if (!vchk) {
					seqCon++;

					// 연속된 자음이 3개인 경우
					if (seqCon == 3) {
						check = false;
						break;
					}

					seqVowel = 0;
				}

				// prev갱신
				prev = temp;
			}

			// 모음이 없는 경우
			if (vowelcnt == 0)
				check = false;

			// accept인 경우
			if (check) {
				sb.append("<" + s + ">").append(accept).append("\n");
			} // not accept
			else {
				sb.append("<" + s + ">").append(notaccept).append("\n");
			}
		}
		System.out.println(sb);
	}
}