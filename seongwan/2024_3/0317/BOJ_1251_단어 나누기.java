import java.io.BufferedReader;
import java.io.InputStreamReader;

//나눌 곳의 위치를 조합으로 찾고 쪼개고 뒤집어서 합친 문자들을 비교해서
//사전 순으로 가장 앞서는 단어를 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int length;
	static StringBuilder ans = new StringBuilder();
	static String s;

	public static void main(String[] args) throws Exception {
		s = br.readLine();
		length = s.length();

		comb();
		System.out.println(ans);
	}

	static void comb() {
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < length - 2; i++) {
			temp.setLength(0);
			temp.append(s.substring(0, i + 1));
			String first = temp.reverse().toString();
			for (int j = i + 1; j < length - 1; j++) {
				sb.setLength(0);
				temp.setLength(0);
				temp.append(s.substring(i + 1, j + 1));
				temp.reverse();
				sb.append(first + temp);

				temp.setLength(0);
				temp.append(s.substring(j + 1, s.length()));
				temp.reverse();
				sb.append(temp);

				if (ans.length() == 0) {
					ans.append(sb);
				} else {
					if (ans.toString().compareTo(sb.toString()) > 0) {
						ans.setLength(0);
						ans.append(sb);
					}
				}
			}
		}
	}
}