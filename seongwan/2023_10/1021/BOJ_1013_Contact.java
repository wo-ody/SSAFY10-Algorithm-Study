import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static String s;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			s = br.readLine();
			if (s.matches("(100+1+|01)+"))
				sb.append("YES" + "\n");
			else
				sb.append("NO" + "\n");
		}
		System.out.println(sb);
	}
}