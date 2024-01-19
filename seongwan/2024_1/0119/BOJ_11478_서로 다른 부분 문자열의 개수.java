import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//받은 문자열의 0~i번 인덱스부터 시작해서 끝이 0~i인 부분 문자열들을
//다 set에 넣은 후 set의 사이즈를 구하면 정답
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				set.add(s.substring(i, j + 1));
			}
		}
		System.out.println(set.size());
	}
}