import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String s;
	static int N, ans;

	public static void main(String[] args) throws Exception {
		s = br.readLine();
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			String ring = temp + temp;

			for (int j = 0; j < ring.length() - s.length(); j++) {
				if (ring.charAt(j) == s.charAt(0)) {
					boolean check = true;
					for (int k = 1; k < s.length(); k++) {
						if (s.charAt(k) != ring.charAt(j + k)) {
							check = false;
							break;
						}
					}
					if (check) {
						ans++;
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}