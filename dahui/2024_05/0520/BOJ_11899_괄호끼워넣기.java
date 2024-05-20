import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11899_괄호끼워넣기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt2 = 0;
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(')
				cnt2++;
			else {
				if (cnt2 == 0)
					cnt++;
				else {
					cnt2--;
				}
			}
		}
		cnt += cnt2;
		System.out.println(cnt);

	}

}
