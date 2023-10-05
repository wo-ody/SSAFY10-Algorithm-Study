package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1284_집_주소 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		while (!s.equals("0")) {
			int cnt = 0;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1')
					cnt += 2;
				else if (s.charAt(i) == '0')
					cnt += 4;
				else
					cnt += 3;
				cnt += 1;
			}
			cnt += 1;
			System.out.println(cnt);

			s = br.readLine();
		}
	}
}
