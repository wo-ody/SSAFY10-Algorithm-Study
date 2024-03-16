import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_27964_콰트로치즈피자 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String str = st.nextToken();
			if (str.endsWith("Cheese")){
				set.add(str);
			}
		}
		if (set.size() >= 4)
			System.out.println("yummy");
		else
			System.out.println("sad");
	}
}
