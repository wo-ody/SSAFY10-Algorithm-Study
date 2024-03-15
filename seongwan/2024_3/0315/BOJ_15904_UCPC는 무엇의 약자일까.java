import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] check = { 'U', 'C', 'P', 'C' };

	public static void main(String[] args) throws Exception {
		char[] c = br.readLine().toCharArray();
		int idx = 0;
		for (char ch : c) {
			if (check[idx] == ch) {
				idx++;
				if (idx == 4)
					break;
			}
		}
		if (idx == 4)
			System.out.println("I love UCPC");
		else
			System.out.println("I hate UCPC");
	}
}