import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans;
	static int[] count = new int[2];

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			char temp = s.charAt(i);
			if (temp == 'K') {
				if (count[0] > 0) {
					count[0]--;
					ans++;
				} else {
					break;
				}
			} else if (temp == 'R') {
				if (count[1] > 0) {
					count[1]--;
					ans++;
				} else {
					break;
				}
			} else if (temp == 'S') {
				count[0]++;
			} else if (temp == 'L') {
				count[1]++;
			} else {
				ans++;
			}
		}
		System.out.println(ans);
	}
}