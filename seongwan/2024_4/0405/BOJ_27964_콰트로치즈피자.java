import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//이름이 Cheese로 끝나는 문자열을 set에 넣은 후
//개수가 4라면 "yummy" 1
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			String temp = st.nextToken();
			if (temp.endsWith("Cheese"))
				set.add(temp);
		}

		System.out.println(set.size() >= 4 ? "yummy" : "sad");
	}
}