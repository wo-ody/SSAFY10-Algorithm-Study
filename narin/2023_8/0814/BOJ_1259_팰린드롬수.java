import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static String num;
	private static char[] arr, rev;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			num = br.readLine();
			if (num.equals("0")) {
				break;
			}

			arr = new char[num.length()];
			rev = new char[num.length()];

			for (int n = 0; n < num.length(); n++) {
				arr[n] = num.charAt(n);
				rev[num.length() - 1 - n] = arr[n];
			}

			if (Arrays.equals(arr, rev)) {
				System.out.println("yes");
			} else {
				System.out.println("no");

			}
		}
	}
}
