import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ_16499_동일한단어그룹화하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] c = str.toCharArray();
			Arrays.sort(c);
			set.add(Arrays.toString(c));
		}
		System.out.println(set.size());
	}
}
