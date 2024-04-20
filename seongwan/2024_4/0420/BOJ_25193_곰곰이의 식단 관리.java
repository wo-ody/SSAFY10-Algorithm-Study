import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, chicken, another = 1;
	static String s;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		s = br.readLine();

		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == 'C') {
				chicken++;
			} else {
				another++;
			}
		}
		int ans = chicken / another;
		System.out.println(chicken % another >= 1 ? ans + 1 : ans);
	}
}