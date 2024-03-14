import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int time;

	public static void main(String[] args) throws Exception {
		String s = br.readLine();
		while (s.length() != 1) {
			time++;
			char[] temp = s.toCharArray();
			int cnt = 0;
			for (int i = 0; i < temp.length; i++) {
				cnt += temp[i] - '0';
			}
			s = String.valueOf(cnt);
		}

		System.out.println(time);
		if (s.equals("3") || s.equals("6") || s.equals("9")) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}